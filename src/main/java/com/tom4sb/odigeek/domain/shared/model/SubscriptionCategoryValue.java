package com.tom4sb.odigeek.domain.shared.model;

import java.util.Optional;

public enum SubscriptionCategoryValue {
  ANIME,
  LIVING_BEINGS,
  SOAP_OPERA;


  public static Optional<SubscriptionCategoryValue> create(final String categoryName) {
    try {
      return Optional.of(SubscriptionCategoryValue.valueOf(categoryName));
    } catch (final IllegalArgumentException e) {
      return Optional.empty();
    }
  }

}