package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserFullName(
    String value
) {

  public UserFullName {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("User full name cannot be null");
    }
  }

}
