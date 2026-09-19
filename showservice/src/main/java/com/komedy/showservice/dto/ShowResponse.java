package com.komedy.showservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
public class ShowResponse {

    private Long id;

    private UUID comedianId;

    private Long venueId;

    private String title;

    private String description;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer ticketPrice;
}
