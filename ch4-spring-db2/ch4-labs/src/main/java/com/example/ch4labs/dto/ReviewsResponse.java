package com.example.ch4labs.dto;

import com.example.ch4labs.domain.Reviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public static ReviewsResponse from(Reviews reviews) {
        return new ReviewsResponse(
                reviews.getId(),
                reviews.getTitle(),
                reviews.getContent(),
                reviews.getAuthor(),
                reviews.getBookTitle(),
                reviews.getBookAuthor(),
                reviews.getRating()
        );
    }
}
