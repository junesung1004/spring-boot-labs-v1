package com.example.ch2labs.labs07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseDto {
    private long id;
    private String title;
    private Boolean completed;
}
