package com.tom4sb.odigeek.application.subscription.command.update_status;

import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.application.subscription.command.update_price.UpdateSubscriptionPriceHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionStatus;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public final class UpdateSubscriptionStatusHandler
    implements CommandHandler<UpdateSubscriptionStatus> {

  private static final Logger log = LoggerFactory.getLogger(UpdateSubscriptionStatusHandler.class);
  private final Subscriptions subscriptions;

  public UpdateSubscriptionStatusHandler(final Subscriptions subscriptions) {
    this.subscriptions = subscriptions;
  }

  @Override
  public void handle(final UpdateSubscriptionStatus command) {
    subscriptions.findById(new SubscriptionId(command.getId()))
        .ifPresent(value -> {
              value.updateStatus(new SubscriptionStatus(command.getStatus()));
              subscriptions.save(value);
              log.info("Subscription status updated! {}", value.toStringForLog());
            }
        );
  }

}
