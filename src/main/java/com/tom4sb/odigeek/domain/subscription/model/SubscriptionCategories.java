package com.tom4sb.odigeek.domain.subscription.model;

import com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SubscriptionCategories {

  private final Set<SubscriptionCategoryValue> values;

  public SubscriptionCategories(final List<String> categoryNames) {
    if (Objects.isNull(categoryNames) || categoryNames.isEmpty()) {
      throw new IllegalArgumentException("Subscription categories cannot be null or empty");
    }
    this.values = buildCategories(categoryNames);
  }

  public Set<SubscriptionCategoryValue> getValues() {
    return values;
  }

  private static Set<SubscriptionCategoryValue> buildCategories(final List<String> categoryNames) {
    return categoryNames.stream()
        .map(SubscriptionCategoryValue::create)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toSet());
  }

}
