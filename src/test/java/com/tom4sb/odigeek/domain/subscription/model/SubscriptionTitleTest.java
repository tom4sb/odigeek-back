package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

final class SubscriptionTitleTest {

  @Test
  void should_fail_with_null_value() {
    assertThatThrownBy(() -> new SubscriptionTitle(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_value() {
    assertThatThrownBy(() -> new SubscriptionTitle("INVALID_TITLE"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
