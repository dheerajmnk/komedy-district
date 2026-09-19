package com.komedy.showservice.mapper;

import com.komedy.showservice.dto.CreateShowRequest;
import com.komedy.showservice.dto.ShowResponse;
import com.komedy.showservice.entity.Show;

public class ShowMapper {

    public static Show toEntity(CreateShowRequest request) {
        Show show = new Show();
        show.setComedianId(request.getComedianId());
        show.setVenueId(request.getVenueId());
        show.setTitle(request.getTitle());
        show.setDescription(request.getDescription());
        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());
        show.setTicketPrice(request.getTicketPrice());
        return show;
    }

    public static ShowResponse toResponse(Show show) {
        ShowResponse response = new ShowResponse();

        response.setId(show.getId());
        response.setComedianId(show.getComedianId());
        response.setVenueId(show.getVenueId());
        response.setTitle(show.getTitle());
        response.setDescription(show.getDescription());
        response.setDate(show.getStartTime().toLocalDate());
        response.setStartTime(show.getStartTime().toLocalTime());
        response.setEndTime(show.getEndTime().toLocalTime());
        response.setTicketPrice(show.getTicketPrice());

        return response;
    }
}
