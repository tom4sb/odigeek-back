package com.tom4sb.odigeek.application.subscription.command.update_price;

import com.tom4sb.odigeek.domain.shared.messaging.Command;
import java.util.UUID;

public final class UpdateSubscriptionPrice
    extends Command {

  private final UUID id;
  private final Double price;
  private final String currencyCode;

  public UpdateSubscriptionPrice(
      final UUID id,
      final Double price,
      final String currencyCode
  ) {
    this.id = id;
    this.price = price;
    this.currencyCode = currencyCode;
  }

  public UUID getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

}