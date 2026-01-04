package com.example.book_recommendation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
    
    Map<String, Object> response = new HashMap<>();
    response.put("message", ex.getMessage()); // 에러메시지
    response.put("errorCode", ex.getErrorCode()); // 에러코드
    response.put("status", ex.getStatus()); // HTTP 상태코드

    return new ResponseEntity<>(response, ex.getStatus());
  }
}
