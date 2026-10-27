package com.example.elearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(com.example.elearning.EnrollmentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleEnrollmentNotFound(
            com.example.elearning.EnrollmentNotFoundException ex
    ) {
        Map<String, String> error = Map.of(
                "error", "Not Found",
                "message", ex.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }


}