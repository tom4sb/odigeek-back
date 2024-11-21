package com.tom4sb.odigeek.domain.subscription.model;

public record SubscriptionDescription(
    String value
) {

  public SubscriptionDescription {
    if (value == null) {
      throw new IllegalArgumentException("Subscription description cannot be null");
    }
  }

}
