package com.example.ch2labs.labs07.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoValidationException extends RuntimeException {
    private String message;
    private String code;
}
