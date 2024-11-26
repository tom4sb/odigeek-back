package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class SubscriptionContentTest {

  @Test
  void should_fail_with_null_values() {
    assertThatThrownBy(() -> new SubscriptionContent(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_empty_values() {
    assertThatThrownBy(() -> new SubscriptionContent(Collections.emptyMap()))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
