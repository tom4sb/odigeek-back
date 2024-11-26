package com.tom4sb.odigeek.application.subscription.command.create;

import com.tom4sb.odigeek.domain.shared.messaging.Command;
import java.util.List;
import java.util.UUID;

public final class CreateSubscription
    extends Command {

  private final UUID id;
  private final String title;
  private final List<String> categories;
  private final Double priceAmount;
  private final String priceCurrency;
  private final String description;

  public CreateSubscription(
      final UUID id,
      final String title,
      final List<String> categories,
      final Double priceAmount,
      final String priceCurrency,
      final String description
  ) {
    this.id = id;
    this.title = title;
    this.categories = categories;
    this.priceAmount = priceAmount;
    this.priceCurrency = priceCurrency;
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

  public Double getPriceAmount() {
    return priceAmount;
  }

  public String getPriceCurrency() {
    return priceCurrency;
  }

  public String getDescription() {
    return description;
  }

}
