package com.tom4sb.odigeek.domain.user.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserPhoneTest {

  static String invalidCountryCode;
  static String validCountryCode;
  static String invalidPhoneNumber;
  static String validPhoneNumber;

  @BeforeAll
  static void setUp() {
    final var random = new Random();
    invalidCountryCode = "+" + String.format("%01d", random.nextInt(10)) + "A";
    validCountryCode = "+" + String.format("%02d", new Random().nextInt(100));
    invalidPhoneNumber = String.format("%08d", new Random().nextInt(100000000)) + "A";
    validPhoneNumber = String.format("%09d", new Random().nextInt(1000000000));
  }

  @Test
  void should_fail_with_null_value() {
    assertThatThrownBy(() -> new UserPhone(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_value_and_without_country_code() {
    assertThatThrownBy(() -> new UserPhone(invalidPhoneNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_valid_value_and_without_country_code() {
    assertThatThrownBy(() -> new UserPhone(validPhoneNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_value_and_invalid_country_code() {
    assertThatThrownBy(() -> new UserPhone(invalidCountryCode + invalidPhoneNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_value_and_valid_country_code() {
    assertThatThrownBy(() -> new UserPhone(invalidCountryCode + validPhoneNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_valid_value_and_invalid_country_code() {
    assertThatThrownBy(() -> new UserPhone(validCountryCode + invalidPhoneNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
