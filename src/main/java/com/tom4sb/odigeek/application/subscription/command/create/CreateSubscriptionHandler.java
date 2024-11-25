package com.tom4sb.odigeek.application.subscription.command.create;

import com.tom4sb.odigeek.domain.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionCategories;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionDataLoader;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionDescription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import org.springframework.stereotype.Service;

@Service
public final class CreateSubscriptionHandler
    implements CommandHandler<CreateSubscription> {

  private final SubscriptionDataLoader subscriptionDataLoader;
  private final Subscriptions subscriptions;

  public CreateSubscriptionHandler(
      final SubscriptionDataLoader subscriptionDataLoader,
      final Subscriptions subscriptions
  ) {
    this.subscriptionDataLoader = subscriptionDataLoader;
    this.subscriptions = subscriptions;
  }

  public void handle(final CreateSubscription command) {
    final var id = new SubscriptionId(command.getId());
    final var title = new SubscriptionTitle(command.getTitle());
    final var categories = new SubscriptionCategories(command.getCategories());
    final var price = new SubscriptionPrice(command.getPrice(), command.getCurrencyCode());
    final var description = new SubscriptionDescription(command.getDescription());
    final var content = subscriptionDataLoader.load(title);

    final var subscription = Subscription.create(
        id,
        title,
        categories,
        price,
        description,
        content
    );

    subscriptions.save(subscription);
  }

}
