package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SubscriptionDescriptionTest {

  @Test
  void should_fail_with_null_value() {
    assertThatThrownBy(() -> new SubscriptionDescription(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
