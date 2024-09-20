package com.betrybe.agrix.controller.advice;

import com.betrybe.agrix.controller.exception.FarmBadRequestException;
import com.betrybe.agrix.controller.exception.FarmNotFoundException;
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

  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handleFarmNotFoundException(FarmNotFoundException exception) {
    return ResponseEntity.status((HttpStatus.NOT_FOUND)).body(exception.getMessage());
  }
}
