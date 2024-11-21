package com.tom4sb.odigeek.domain.subscription.model;

public record SubscriptionPrice(
    Double value
) {

  public SubscriptionPrice {
    if (value == null || value < 0.0) {
      throw new IllegalArgumentException("Subscription price cannot be null or negative");
    }
  }

}
