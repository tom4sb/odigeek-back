package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.Test;

final class SubscriptionCategoriesTest {

  @Test
  void should_fail_with_null_values() {
    assertThatThrownBy(() -> new SubscriptionCategories(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_empty_values() {
    assertThatThrownBy(() -> new SubscriptionCategories(Collections.emptyList()))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
