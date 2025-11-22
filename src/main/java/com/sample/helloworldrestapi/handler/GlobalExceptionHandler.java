package com.sample.helloworldrestapi.handler;

import com.sample.helloworldrestapi.exception.InvalidNameException;
import com.sample.helloworldrestapi.model.HelloWorldErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<HelloWorldErrorResponse> handleValidationError(InvalidNameException ex) {
        HelloWorldErrorResponse helloWorldErrorResponse = HelloWorldErrorResponse.builder().error(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(helloWorldErrorResponse);
    }
}
