package com.tom4sb.odigeek.domain.offer.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tom4sb.odigeek.domain.shared.model.CurrencyCode.CurrencyCodeValue;
import java.util.Random;
import org.junit.jupiter.api.Test;

class OfferRuleTest {

  @Test
  void should_fail_with_null_multiplier_and_currency_code() {
    assertThatThrownBy(() -> new OfferRule(null, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_multiplier() {
    assertThatThrownBy(() -> new OfferRule(null, CurrencyCodeValue.EUR.name()))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_currency_code() {
    assertThatThrownBy(() -> new OfferRule(0.5, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_less_than_zero_multiplier() {
    assertThatThrownBy(
        () -> new OfferRule(-new Random().nextDouble(), CurrencyCodeValue.EUR.name())
    )
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_one_or_more_multiplier() {
    assertThatThrownBy(
        () -> new OfferRule(new Random().nextDouble(1, Double.MAX_VALUE), CurrencyCodeValue.EUR.name())
    )
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_currency_code() {
    assertThatThrownBy(() -> new OfferRule(0.5, "INVALID_CURRENCY_CODE"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
