package com.tom4sb.odigeek.infrastructure.api.subscription;

import com.tom4sb.odigeek.domain.subscription.exception.SubscriptionTitleAlreadyExistWithinCategory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SubscriptionExceptionHandler {

  @ExceptionHandler(SubscriptionTitleAlreadyExistWithinCategory.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public void handleSubscriptionTitleAlreadyExistWithinCategory() {

  }

}
