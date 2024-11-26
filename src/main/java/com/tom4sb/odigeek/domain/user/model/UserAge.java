package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserAge(
    Integer value
) {

  public UserAge {
    if (Objects.isNull(value) || value < 18) { // TODO check if is correct
      throw new IllegalArgumentException("User age cannot be null or less than 18");
    }
  }

}
