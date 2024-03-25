package com.younesleonjoe.brewery.exception;

import com.younesleonjoe.brewery.beer.v1.BeerNotFoundException;
import com.younesleonjoe.brewery.customer.CustomerNotFoundException;
import com.younesleonjoe.brewery.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({BeerNotFoundException.class, CustomerNotFoundException.class})
  public ResponseEntity<ErrorResponse> handleException(Exception exception) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
}
