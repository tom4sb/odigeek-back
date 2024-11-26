package com.tom4sb.odigeek.domain.user.model;

import java.util.Objects;

public record UserBankDetails(
    String creditCard,
    String bankAccount
) {

  public UserBankDetails {
    if (Objects.isNull(creditCard)) {
      throw new IllegalArgumentException("User credit card cannot be null");
    }
    if (!creditCard.matches("^\\d{16}$")) {
      throw new IllegalArgumentException("Invalid user credit card format");
    }
    if (Objects.isNull(bankAccount)) {
      throw new IllegalArgumentException("User bank account cannot be null");
    }
    if (!bankAccount.matches("^\\d{10,20}$")) {
      throw new IllegalArgumentException("Invalid user bank account format");
    }
  }

}
