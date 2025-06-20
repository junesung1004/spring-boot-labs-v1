package com.example.ch4labs.dto;

import com.example.ch4labs.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateRequest {
    private String title;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private String content;
    private int rating;

    public Review toDomain() {
        Review review = new Review();
        review.setTitle(title);
        review.setAuthor(author);
        review.setBookTitle(bookTitle);
        review.setBookAuthor(bookAuthor);
        review.setContent(content);
        review.setRating(rating);
        return review;
    }

}
