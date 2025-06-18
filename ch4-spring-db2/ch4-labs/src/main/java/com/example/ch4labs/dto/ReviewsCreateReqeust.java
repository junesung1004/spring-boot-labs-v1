package com.example.ch4labs.dto;


import com.example.ch4labs.domain.Reviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsCreateReqeust {

    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public Reviews toDomain() {
        Reviews reviews = new Reviews();
        reviews.setTitle(title);
        reviews.setContent(content);
        reviews.setAuthor(author);
        reviews.setBookTitle(bookTitle);
        reviews.setBookAuthor(bookAuthor);
        reviews.setRating(rating);
        return reviews;
    }
}
