package com.tom4sb.odigeek.infrastructure.api;

import com.tom4sb.odigeek.domain.subscription.exception.SubscriptionTitleAlreadyExistWithinCategory;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SubscriptionExceptionHandler {

  @ExceptionHandler(SubscriptionTitleAlreadyExistWithinCategory.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public String handleSubscriptionTitleAlreadyExistWithinCategory() {
    return "Exception SubscriptionTitleAlreadyExistWithinCategory thrown.";
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNoSuchElementException() {
    return "Exception NoSuchElementException thrown.";
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleIllegalArgumentException(final IllegalArgumentException e) {
    return "Exception IllegalArgumentException thrown: " + e.getMessage();
  }

}
