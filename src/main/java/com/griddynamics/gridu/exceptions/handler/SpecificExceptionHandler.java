package com.griddynamics.gridu.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class SpecificExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleException(ResponseStatusException e) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getReason());
        return new ResponseEntity<>(errorDetails, e.getStatus());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleException(NullPointerException e) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Bad request data");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
