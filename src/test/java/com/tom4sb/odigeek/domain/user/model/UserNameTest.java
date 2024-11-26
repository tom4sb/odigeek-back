package com.tom4sb.odigeek.domain.user.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserNameTest {

  @Test
  void should_fail_with_null_value() {
    assertThatThrownBy(() -> new UserName(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_empty_value() {
    assertThatThrownBy(() -> new UserName(""))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
