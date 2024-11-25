package com.tom4sb.odigeek.application.subscription.command.create;

import com.tom4sb.odigeek.domain.shared.messaging.Command;
import java.util.List;
import java.util.UUID;

public final class CreateSubscription
    extends Command {

  private final UUID id;
  private final String title;
  private final List<String> categories;
  private final Double price;
  private final String currencyCode;
  private final String description;

  public CreateSubscription(
      final UUID id,
      final String title,
      final List<String> categories,
      final Double price,
      final String currencyCode,
      final String description
  ) {
    this.id = id;
    this.title = title;
    this.categories = categories;
    this.price = price;
    this.currencyCode = currencyCode;
    this.description = description;
  }

  public UUID getId() {
    return id;
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
