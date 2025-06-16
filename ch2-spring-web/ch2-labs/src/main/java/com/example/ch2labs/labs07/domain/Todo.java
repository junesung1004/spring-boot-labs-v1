package com.example.ch2labs.labs07.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
}