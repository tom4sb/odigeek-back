package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserHomeCity(
    String value
) {

  public UserHomeCity {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("User home city cannot be null");
    }
  }

}
