package com.komedy.showservice.service;

import com.komedy.showservice.dto.CreateShowRequest;
import com.komedy.showservice.dto.ShowResponse;
import com.komedy.showservice.entity.Show;
import com.komedy.showservice.exception.BadRequestException;
import com.komedy.showservice.exception.ResourceNotFoundException;
import com.komedy.showservice.mapper.ShowMapper;
import com.komedy.showservice.repository.ShowRepository;
import com.komedy.showservice.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    private final VenueRepository venueRepository;

    public ShowResponse createShow(CreateShowRequest request) {

        if (!request.getStartTime().isBefore(request.getEndTime())) {
            throw new BadRequestException("Start time must be before end time");
        }

        if (request.getStartTime().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Show cannot be scheduled in the past");
        }

        if (!venueRepository.existsById(request.getVenueId())) {
            throw new ResourceNotFoundException(
                    "Venue not found with id: " + request.getVenueId()
            );
        }

        Show show = ShowMapper.toEntity(request);

        Show createdShow = showRepository.save(show);

        return ShowMapper.toResponse(createdShow);

    }

    public ShowResponse getShowById(Long id) {

        Show show = showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException( "Show not found with id: " + id));
        return ShowMapper.toResponse(show);
    }

    public List<ShowResponse> getAllShows() {

        return showRepository.findAll()
                .stream()
                .map(ShowMapper::toResponse)
                .toList();
    }
}
