package com.tom4sb.odigeek.domain.subscription.model;

import java.util.Objects;

public record SubscriptionDescription(
    String value
) {

  public SubscriptionDescription {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("Subscription description cannot be null");
    }
  }

}
