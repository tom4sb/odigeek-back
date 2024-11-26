package com.tom4sb.odigeek.domain.subscription.model;

public record SubscriptionStatus(
    boolean value
) {

  public boolean isInactive() {
    return !value;
  }

}
