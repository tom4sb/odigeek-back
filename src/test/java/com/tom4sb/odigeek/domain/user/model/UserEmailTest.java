package com.tom4sb.odigeek.domain.user.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserEmailTest {

  @Test
  void should_fail_with_null_value() {
    assertThatThrownBy(() -> new UserEmail(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_format() {
    assertThatThrownBy(() -> new UserEmail("user-domain.com"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_format_without_domain() {
    assertThatThrownBy(() -> new UserEmail("user@"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_format_without_user() {
    assertThatThrownBy(() -> new UserEmail("@domain.com"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_format_without_extension() {
    assertThatThrownBy(() -> new UserEmail("user@domain"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
