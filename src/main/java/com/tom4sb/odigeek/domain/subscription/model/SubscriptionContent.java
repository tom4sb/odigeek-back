package com.tom4sb.odigeek.domain.subscription.model;

import java.util.List;
import java.util.Map;

public record SubscriptionContent(
    Map<ContentType, List<SubscriptionContentInfo>> values
) {

  public SubscriptionContent {
    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("Subscription content cannot be null");
    }
  }

  public enum ContentType {
    DATA,
    FIGURES
  }

}
