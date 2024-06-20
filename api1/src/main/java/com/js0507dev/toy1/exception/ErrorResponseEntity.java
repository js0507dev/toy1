package com.js0507dev.toy1.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponseEntity {
  private final String code;
  private final String message;

  public static ResponseEntity<ErrorResponseEntity> toResponseEntity(BaseException e) {
    return ResponseEntity
        .status(e.getStatus())
        .body(ErrorResponseEntity
            .builder()
            .code(e.getCode())
            .message(e.getMessage())
            .build());
  }

  public static ResponseEntity<ErrorResponseEntity> toResponseEntity(Exception e) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorResponseEntity
            .builder()
            .code("TEMP-CODE-999")
            .message(e.getMessage())
            .build());
  }
}
