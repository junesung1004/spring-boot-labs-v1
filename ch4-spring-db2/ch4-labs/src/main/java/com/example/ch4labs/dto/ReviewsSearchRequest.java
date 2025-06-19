package com.example.ch4labs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsSearchRequest {

    private String keyword;
    private String keywordType;
    private String bookTitle;
    private String author;
    private Integer rating;
    private int page = 0;
    private int size = 10;
}
