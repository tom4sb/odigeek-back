package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserPassword(
    String value
) {

  public UserPassword {
    if (Objects.isNull(value) || value.length() < 8) { // TODO encrypt pass
      throw new IllegalArgumentException("User password cannot be null and must be at least 8 characters long");
    }
  }

}
