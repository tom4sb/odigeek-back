package com.tom4sb.odigeek.domain.subscription.model;

import java.util.Objects;
import java.util.UUID;

public record SubscriptionId(
    UUID value
) {

  public SubscriptionId {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("Subscription ID cannot be null");
    }
  }

}
