package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;
import java.util.Optional;

public class UserRole {

  private final RoleValue value;

  public UserRole(final String roleName) {
    if (Objects.isNull(roleName) || roleName.isBlank()) {
      throw new IllegalArgumentException("User role cannot be null or blank");
    }
    this.value = RoleValue.create(roleName)
        .orElseThrow(() -> new IllegalArgumentException("Role does not exist"));
  }

  public RoleValue getValue() {
    return value;
  }


  public enum RoleValue {
    BI_TEAM,
    FINANCE_TEAM,
    GEEK_SPECIALIST,
    SALES_TEAM,
    USER;


    public static Optional<RoleValue> create(final String roleName) {
      try {
        return Optional.of(RoleValue.valueOf(roleName));
      } catch (final IllegalArgumentException | NullPointerException e) {
        return Optional.empty();
      }
    }

  }

  @Override
  public String toString() {
    return "UserRole{" +
        "value=" + value +
        '}';
  }

}
