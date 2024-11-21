package com.tom4sb.odigeek.domain.subscription.model;

public record SubscriptionTitle(
    String value
) {

  public SubscriptionTitle {
    if (value == null) {
      throw new IllegalArgumentException("Subscription title cannot be null");
    }
  }

}
