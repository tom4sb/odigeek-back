package com.tom4sb.odigeek.application.subscription.command.update_status;

import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionStatus;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import org.springframework.stereotype.Service;

@Service
public final class UpdateSubscriptionStatusHandler
    implements CommandHandler<UpdateSubscriptionStatus> {

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
            }
        );
  }

}
