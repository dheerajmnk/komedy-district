package com.komedy.showservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateShowRequest {

    @NotNull
    private UUID comedianId;

    @NotNull
    private Long venueId;

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotNull
    @Positive
    private Integer ticketPrice;
}
