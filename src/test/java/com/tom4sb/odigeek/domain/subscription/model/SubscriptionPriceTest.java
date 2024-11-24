package com.tom4sb.odigeek.domain.subscription.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice.CurrencyCode;
import java.util.Random;
import org.junit.jupiter.api.Test;

final class SubscriptionPriceTest {

  @Test
  void should_fail_with_null_price_and_currency_code() {
    assertThatThrownBy(() -> new SubscriptionPrice(null, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_price() {
    assertThatThrownBy(() -> new SubscriptionPrice(null, CurrencyCode.EUR.name()))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_currency_code() {
    assertThatThrownBy(() -> new SubscriptionPrice(5.0, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_negative_price() {
    assertThatThrownBy(
        () -> new SubscriptionPrice(-new Random().nextDouble(), CurrencyCode.EUR.name())
    )
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_invalid_currency_code() {
    assertThatThrownBy(() -> new SubscriptionPrice(5.0, "INVALID_CURRENCY_CODE"))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
