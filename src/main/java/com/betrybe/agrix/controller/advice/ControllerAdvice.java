package com.betrybe.agrix.controller.advice;

import com.betrybe.agrix.controller.exception.FarmBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Controller advice.
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
  @ExceptionHandler(FarmBadRequestException.class)
  public ResponseEntity<String> handleFarmBadRequest(FarmBadRequestException exception) {
    return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body(exception.getMessage());
  }
}
