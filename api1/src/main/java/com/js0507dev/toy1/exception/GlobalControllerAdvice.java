package com.js0507dev.toy1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler(BaseException.class)
  protected ResponseEntity<ErrorResponseEntity> handleException(BaseException e) {
    return ErrorResponseEntity.toResponseEntity(e);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorResponseEntity> handleException(Exception e) {
    return ErrorResponseEntity.toResponseEntity(e);
  }
}
