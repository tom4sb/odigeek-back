package com.tom4sb.odigeek.application.subscription.command.update_price;

import com.tom4sb.odigeek.domain.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import org.springframework.stereotype.Service;

@Service
public final class UpdateSubscriptionPriceHandler
    implements CommandHandler<UpdateSubscriptionPrice> {

  private final Subscriptions subscriptions;

  public UpdateSubscriptionPriceHandler(final Subscriptions subscriptions) {
    this.subscriptions = subscriptions;
  }

  public void handle(final UpdateSubscriptionPrice command) {
    subscriptions.get(new SubscriptionId(command.getId()))
        .ifPresent(value -> {
              value.updatePrice(new SubscriptionPrice(command.getPrice(), command.getCurrencyCode()));
              subscriptions.save(value);
            }
        );
  }

}