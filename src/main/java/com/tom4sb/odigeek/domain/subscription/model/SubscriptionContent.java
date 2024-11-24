package com.tom4sb.odigeek.domain.subscription.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public record SubscriptionContent(
    Map<ContentType, List<SubscriptionContentInfo>> values
) {

  public SubscriptionContent {
    if (Objects.isNull(values) || values.isEmpty()) {
      throw new IllegalArgumentException("Subscription content cannot be null");
    }
  }


  public record SubscriptionContentInfo(
      Map<String, Object> values
  ) {

  }


  public enum ContentType {
    DATA,
    FIGURES
  }

}
