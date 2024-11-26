package com.tom4sb.odigeek.domain.shared.model;

public record CurrencyCode(
    CurrencyCodeValue value
) {

  public static CurrencyCode create(final String currencyCodeName) {
    try {
      return new CurrencyCode(CurrencyCodeValue.valueOf(currencyCodeName));
    } catch (final IllegalArgumentException e) {
      throw new IllegalArgumentException("Currency code does not exist");
    }
  }


  public enum CurrencyCodeValue {
    EUR,
    USD
  }

}
