package com.komedy.showservice.controller;

import com.komedy.showservice.entity.Venue;
import com.komedy.showservice.service.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/venue")
public class AdminVenueController {

    private final VenueService venueService;

    @PostMapping
    public Venue createVenue(@Valid @RequestBody Venue venue) {
        return venueService.createVenue(venue);
    }

}
