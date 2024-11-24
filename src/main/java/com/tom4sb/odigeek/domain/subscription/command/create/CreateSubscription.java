package com.tom4sb.odigeek.domain.subscription.command.create;

import java.util.List;

public final class CreateSubscription {

  private final String title;
  private final List<String> categories;
  private final Double price;
  private final String currencyCode;
  private final String description;

  public CreateSubscription(
      final String title,
      final List<String> categories,
      final Double price,
      final String currencyCode,
      final String description
  ) {
    this.title = title;
    this.categories = categories;
    this.price = price;
    this.currencyCode = currencyCode;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getCategories() {
    return categories;
  }

  public Double getPrice() {
    return price;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public String getDescription() {
    return description;
  }

}
