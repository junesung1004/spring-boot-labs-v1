package com.example.ch4labs.dto.review;


import com.example.ch4labs.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewUpdateRequest {
    private String title;
    private String content;
    private int rating;

    public Review toDomain() {
        Review review = new Review();
        review.setTitle(title);
        review.setContent(content);
        review.setRating(rating);
        return review;
    }
}
