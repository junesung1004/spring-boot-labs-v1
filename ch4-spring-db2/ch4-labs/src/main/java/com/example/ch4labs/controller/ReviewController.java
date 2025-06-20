package com.example.ch4labs.controller;

import com.example.ch4labs.dto.*;
import com.example.ch4labs.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
@Transactional
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponse> create(@RequestBody ReviewCreateRequest request) {
        return ResponseEntity.ok(reviewService.createReview(request));
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<ReviewPageResponse> getAllReviews(ReviewSearchRequest request) {
        return ResponseEntity.ok(reviewService.getAllReviews(request)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getByIdReview(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponse> updateReview(@PathVariable Long id, @RequestBody ReviewUpdateRequest request) {
        return ResponseEntity.ok(reviewService.updateReview(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
