package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;
import java.util.UUID;

public record UserId(
    UUID value
) {

  public UserId {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("User ID cannot be null");
    }
  }

}
