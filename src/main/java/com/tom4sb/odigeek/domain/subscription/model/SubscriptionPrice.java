package com.tom4sb.odigeek.domain.subscription.model;

import java.util.Currency;
import java.util.Objects;

public class SubscriptionPrice {

  private final Double price;
  private final Currency currency;

  public SubscriptionPrice(final Double price, final String currencyCodeName) {
    if (Objects.isNull(price) || price < 0.0) {
      throw new IllegalArgumentException("Subscription price cannot be null or negative");
    }
    if (Objects.isNull(currencyCodeName)) {
      throw new IllegalArgumentException("Subscription price currency code cannot be null");
    }
    this.price = price;
    this.currency = buildCurrencyCode(currencyCodeName);
  }

  public Double getPrice() {
    return price;
  }

  public Currency getCurrency() {
    return currency;
  }

  private Currency buildCurrencyCode(final String currencyCodeName) {
    try {
      return Currency.getInstance(CurrencyCode.valueOf(currencyCodeName).name());
    } catch (final IllegalArgumentException e) {
      throw new IllegalArgumentException("Currency code does not exist");
    }
  }


  public enum CurrencyCode {
    EUR,
    USD
  }

}
