package com.example.jpa.common.handler;

import com.example.jpa.common.model.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> authFailException(ArithmeticException exception ){
        return ResponseResult.fail(exception.getMessage());
    }
}
