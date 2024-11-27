package com.tom4sb.odigeek.infrastructure.api;

import com.tom4sb.odigeek.domain.subscription.exception.SubscriptionTitleAlreadyExistWithinCategory;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(SubscriptionTitleAlreadyExistWithinCategory.class)
  public ResponseEntity<String> handleSubscriptionTitleAlreadyExistWithinCategory() {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body("Exception SubscriptionTitleAlreadyExistWithinCategory thrown.");
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoSuchElementException() {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Exception NoSuchElementException thrown.");
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgumentException(final IllegalArgumentException e) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Exception IllegalArgumentException thrown: " + e.getMessage());
  }

}
