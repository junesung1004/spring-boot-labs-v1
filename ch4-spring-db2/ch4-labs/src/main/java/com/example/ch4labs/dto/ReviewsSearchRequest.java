package com.example.ch4labs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsSearchRequest {

    private String keyword = "";
    private int page = 0;
    private int size = 10;
}
