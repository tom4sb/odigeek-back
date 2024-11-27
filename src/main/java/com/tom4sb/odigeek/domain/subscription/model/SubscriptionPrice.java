package com.tom4sb.odigeek.domain.subscription.model;

import com.tom4sb.odigeek.domain.shared.model.CurrencyCode;
import java.util.Objects;

public class SubscriptionPrice {

  private final Double amount;
  private final CurrencyCode currency;

  public SubscriptionPrice(final Double amount, final String currencyCodeName) {
    if (Objects.isNull(amount) || amount < 0.0) {
      throw new IllegalArgumentException("Subscription price amount cannot be null or negative");
    }
    if (Objects.isNull(currencyCodeName)) {
      throw new IllegalArgumentException("Subscription price currency code cannot be null");
    }
    this.amount = amount;
    this.currency = CurrencyCode.create(currencyCodeName);
  }

  public Double getAmount() {
    return amount;
  }

  public CurrencyCode getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return "SubscriptionPrice{" +
        "amount=" + amount +
        ", currency=" + currency +
        '}';
  }

}
