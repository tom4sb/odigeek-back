package com.tom4sb.odigeek.domain.subscription.model;

import java.util.Set;

public record SubscriptionCategory(
    Set<SubscriptionCategoryValue> values
) {

  public SubscriptionCategory {
    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("Subscription category cannot be null or empty");
    }
  }

  public enum SubscriptionCategoryValue {
    ANIME
  }

}
