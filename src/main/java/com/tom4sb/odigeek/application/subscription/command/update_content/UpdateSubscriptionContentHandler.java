package com.tom4sb.odigeek.application.subscription.command.update_content;

import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionDataLoader;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import org.springframework.stereotype.Service;

@Service
public final class UpdateSubscriptionContentHandler
    implements CommandHandler<UpdateSubscriptionContent> {

  private final SubscriptionDataLoader subscriptionDataLoader;
  private final Subscriptions subscriptions;

  public UpdateSubscriptionContentHandler(
      final SubscriptionDataLoader subscriptionDataLoader,
      final Subscriptions subscriptions
  ) {
    this.subscriptionDataLoader = subscriptionDataLoader;
    this.subscriptions = subscriptions;
  }

  @Override
  public void handle(final UpdateSubscriptionContent command) {
    final var title = new SubscriptionTitle(command.getTitle());

    subscriptions.findByTitle(title)
        .ifPresent(value -> {
              value.updateContent(subscriptionDataLoader.load(title));
              subscriptions.save(value);
            }
        );
  }

}
