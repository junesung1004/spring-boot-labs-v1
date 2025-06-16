package com.example.ch2labs.labs07.exception;


import com.example.ch2labs.labs07.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTodoNotFoundException(TodoNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(TodoValidationException.class)
    public ResponseEntity<ErrorResponse> handleTodoValidationException(TodoValidationException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> asd2(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage()));
    }




}
