package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserPhone(
    String value
) {

  private static final String PHONE_FORMAT_REGEX = "^\\+[0-9]{1,3}([\\s-]?[0-9]+)*$";

  public UserPhone {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("User phone cannot be null");
    }
    if (!value.matches(PHONE_FORMAT_REGEX)) {
      throw new IllegalArgumentException("Invalid user phone format (+34600000000)");
    }
  }

}
