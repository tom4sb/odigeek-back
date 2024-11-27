package com.tom4sb.odigeek.application.subscription.command.update_price;

import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.application.subscription.command.update_content.UpdateSubscriptionContentHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public final class UpdateSubscriptionPriceHandler
    implements CommandHandler<UpdateSubscriptionPrice> {

  private static final Logger log = LoggerFactory.getLogger(UpdateSubscriptionPriceHandler.class);
  private final Subscriptions subscriptions;

  public UpdateSubscriptionPriceHandler(final Subscriptions subscriptions) {
    this.subscriptions = subscriptions;
  }

  @Override
  public void handle(final UpdateSubscriptionPrice command) {
    subscriptions.findById(new SubscriptionId(command.getId()))
        .ifPresent(value -> {
              value.updatePrice(new SubscriptionPrice(command.getPriceAmount(), command.getPriceCurrency()));
              subscriptions.save(value);
              log.info("Subscription price updated! {}", value.toStringForLog());
            }
        );
  }

}
