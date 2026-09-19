package com.komedy.showservice.controller;

import com.komedy.showservice.dto.CreateShowRequest;
import com.komedy.showservice.dto.ShowResponse;
import com.komedy.showservice.service.ShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public ResponseEntity<ShowResponse> createShow(@Valid @RequestBody
                                                   CreateShowRequest request) {

        ShowResponse response = showService.createShow(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponse> getShowById(@PathVariable Long id) {

        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowResponse>> getAllShows() {

        return ResponseEntity.ok(showService.getAllShows());
    }
}
