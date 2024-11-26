package com.tom4sb.odigeek.domain.subscription.model;

import com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue;
import java.util.Objects;

public class SubscriptionTitle {

  private final SubscriptionTitleValue value;

  public SubscriptionTitle(final String titleName) {
    if (Objects.isNull(titleName)) {
      throw new IllegalArgumentException("Subscription title cannot be null");
    }
    this.value = SubscriptionTitleValue.create(titleName)
        .orElseThrow(() -> new IllegalArgumentException("Subscription title does not exist"));
  }

  public SubscriptionTitleValue getValue() {
    return value;
  }

}
