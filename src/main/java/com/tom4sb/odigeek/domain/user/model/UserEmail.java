package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserEmail(
    String value
) {

  private static final String EMAIL_FORMAT_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

  public UserEmail {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("User email cannot be null");
    }
    if (!value.matches(EMAIL_FORMAT_REGEX)) {
      throw new IllegalArgumentException("Invalid user email format (user@domain.com)");
    }
  }

}
