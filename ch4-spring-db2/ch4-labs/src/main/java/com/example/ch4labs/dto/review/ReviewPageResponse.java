package com.example.ch4labs.dto.review;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class ReviewPageResponse {

    private int page;                 // 현재 페이지 번호
    private int size;                 // 페이지당 아이템 수
    private long totalCount;          // 전체 리뷰 수
    private int totalPages;           // 전체 페이지 수
    private List<ReviewResponse> reviews; // 실제 데이터 리스트

    public static ReviewPageResponse from(List<ReviewResponse> reviews, ReviewSearchRequest search, Long count) {
        int totalPages = (int) Math.ceil((double) count / search.getSize());
        return new ReviewPageResponse(
                search.getPage(),
                search.getSize(),
                count,
                totalPages,
                reviews
        );
    }
}
