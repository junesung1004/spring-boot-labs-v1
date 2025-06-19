package com.example.ch4labs.controller;


import com.example.ch4labs.dto.*;

import com.example.ch4labs.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewsService service;


    @PostMapping
    public ResponseEntity<ReviewsResponse> create(@RequestBody ReviewsCreateReqeust reqeust) {
        return ResponseEntity.ok(service.createPost(reqeust)) ;
    }

    @GetMapping
    public ResponseEntity<ReviewsPageResponse> searchReviews(ReviewsSearchRequest search) {
        return ResponseEntity.ok(service.getAllReviews(search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewsResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPostById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ReviewsResponse> updateById(@PathVariable Long id, @RequestBody ReviewsUpdateRequest request) {
        return ResponseEntity.ok(service.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
