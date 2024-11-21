package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;
import org.junit.jupiter.api.Test;

final class SubscriptionPriceTest {

  @Test
  void should_fail_with_null_value() {
    assertThatThrownBy(() -> new SubscriptionPrice(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_negative_value() {
    assertThatThrownBy(() -> new SubscriptionPrice(-new Random().nextDouble()))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
