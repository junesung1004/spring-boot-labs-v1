package com.example.ch4labs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReviewsPageResponse {

    private int page;
    private int size;
    private long totalCount;
    private int totalPages;
    private List<ReviewsResponse> reviews;

    public static ReviewsPageResponse from(List<ReviewsResponse> reviews, ReviewsSearchRequest search, Long count) {

        int totalPages = (int) Math.ceil((double) count / search.getSize());
        return new ReviewsPageResponse(
                search.getPage(),
                search.getSize(),
                count,
                totalPages,
                reviews
        );
    }
}
