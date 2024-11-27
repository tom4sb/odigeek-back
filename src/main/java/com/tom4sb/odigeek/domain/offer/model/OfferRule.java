package com.tom4sb.odigeek.domain.offer.model;

import com.tom4sb.odigeek.domain.shared.model.CurrencyCode;
import java.util.Objects;

public class OfferRule {

  private final Double multiplier;
  private final CurrencyCode currency;

  public OfferRule(final Double multiplier, final String currencyCodeName) {
    if (Objects.isNull(multiplier) || multiplier < 0.0 || multiplier > 0.99) {
      throw new IllegalArgumentException("Offer rule multiplier cannot be null and must be between 0 and 0.99");
    }
    if (Objects.isNull(currencyCodeName)) {
      throw new IllegalArgumentException("Offer rule currency code cannot be null");
    }
    this.multiplier = multiplier;
    this.currency = CurrencyCode.create(currencyCodeName);
  }

  public Double getMultiplier() {
    return multiplier;
  }

  public CurrencyCode getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return "OfferRule{" +
        "multiplier=" + multiplier +
        ", currency=" + currency +
        '}';
  }

}
