package com.tom4sb.odigeek.domain.shared.model;

import java.util.Optional;

public enum SubscriptionCategoryValue {
  ANIME,
  LIVING_BEINGS,
  SPACE_OPERA;


  public static Optional<SubscriptionCategoryValue> create(final String categoryName) {
    try {
      return Optional.of(SubscriptionCategoryValue.valueOf(categoryName));
    } catch (final IllegalArgumentException | NullPointerException e) {
      return Optional.empty();
    }
  }

}
