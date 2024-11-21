package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.Test;

final class SubscriptionCategoryTest {

  @Test
  void should_fail_with_null_values() {
    assertThatThrownBy(() -> new SubscriptionCategory(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_empty_values() {
    assertThatThrownBy(() -> new SubscriptionCategory(Collections.emptySet()))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
