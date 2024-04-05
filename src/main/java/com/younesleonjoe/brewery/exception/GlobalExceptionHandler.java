package com.younesleonjoe.brewery.exception;

import com.younesleonjoe.brewery.beer.v1.BeerNotFoundException;
import com.younesleonjoe.brewery.customer.v1.CustomerNotFoundException;
import com.younesleonjoe.brewery.dto.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(ConstraintViolationException.class)
  ResponseEntity<List> validateErrorHandler(ConstraintViolationException exception) {
    List<String> errors = new ArrayList<>(exception.getConstraintViolations().size());
    exception
        .getConstraintViolations()
        .forEach(
            violation -> errors.add(violation.getPropertyPath() + " : " + violation.getMessage()));
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<List> bindErrorHandler(BindException exception) {
    return new ResponseEntity<>(
        exception.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
  }
}
