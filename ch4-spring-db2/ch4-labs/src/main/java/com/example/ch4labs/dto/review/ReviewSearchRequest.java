package com.example.ch4labs.dto.review;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewSearchRequest {
    private String title;         // 리뷰 제목
    private String author;        // 댓글 작성자
    private String bookTitle;     // 책 제목
    private String bookAuthor;    // 책 저자
    private String content;       // 리뷰 내용 키워드
    private Integer rating;       // 평점 (정확히 일치 검색 or 이상/이하 필터용)

    private LocalDate startDate;
    private LocalDate endDate;

    private String bookTitleContains;
    private Integer minRating;
    private Integer maxRating;

    private LocalDateTime createdAt;

    private String sort;
    private int page = 0;
    private int size = 10;
}
