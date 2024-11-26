package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tom4sb.odigeek.domain.shared.model.CurrencyCode.CurrencyCodeValue;
import java.util.Random;
import org.junit.jupiter.api.Test;

class SubscriptionPriceTest {

  @Test
  void should_fail_with_null_amount_and_currency_code() {
    assertThatThrownBy(() -> new SubscriptionPrice(null, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_amount() {
    assertThatThrownBy(() -> new SubscriptionPrice(null, CurrencyCodeValue.EUR.name()))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_currency_code() {
    assertThatThrownBy(() -> new SubscriptionPrice(5.0, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_negative_amount() {
    assertThatThrownBy(
        () -> new SubscriptionPrice(-new Random().nextDouble(), CurrencyCodeValue.EUR.name())
    )
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_currency_code() {
    assertThatThrownBy(() -> new SubscriptionPrice(5.0, "INVALID_CURRENCY_CODE"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
