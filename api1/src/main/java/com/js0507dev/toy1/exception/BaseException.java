package com.js0507dev.toy1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
  protected final HttpStatus status;
  protected final String code;
  protected final String message;

  @Override
  public String toString() {
    return "BaseException [status=" + status.name() + "code=" + code + ", message=" + message + "]";
  }
}
