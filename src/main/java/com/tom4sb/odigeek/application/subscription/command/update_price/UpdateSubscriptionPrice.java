package com.tom4sb.odigeek.application.subscription.command.update_price;

import com.tom4sb.odigeek.domain.shared.messaging.Command;
import java.util.UUID;

public final class UpdateSubscriptionPrice
    extends Command {

  private final UUID id;
  private final Double priceAmount;
  private final String priceCurrency;

  public UpdateSubscriptionPrice(
      final UUID id,
      final Double priceAmount,
      final String priceCurrency
  ) {
    this.id = id;
    this.priceAmount = priceAmount;
    this.priceCurrency = priceCurrency;
  }

  public UUID getId() {
    return id;
  }

  public Double getPriceAmount() {
    return priceAmount;
  }

  public String getPriceCurrency() {
    return priceCurrency;
  }

}
