package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserName(
    String value
) {

  public UserName {
    if (Objects.isNull(value) || value.isBlank()) {
      throw new IllegalArgumentException("Username cannot be null or empty");
    }
  }

}
