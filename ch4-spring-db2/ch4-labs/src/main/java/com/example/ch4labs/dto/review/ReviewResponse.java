package com.example.ch4labs.dto.review;


import com.example.ch4labs.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {

    private Long id;
    private String title;;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private String content;
    private int rating;
    private LocalDateTime createdAt;


    public static ReviewResponse from(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getTitle(),
                review.getAuthor(),
                review.getBookTitle(),
                review.getBookAuthor(),
                review.getContent(),
                review.getRating(),
                review.getCreatedAt()
        );
    }
}
