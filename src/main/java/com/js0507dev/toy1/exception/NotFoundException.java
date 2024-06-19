package com.js0507dev.toy1.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends BaseException {
  public NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, "TEMP-CODE-001", message);
  }
}
