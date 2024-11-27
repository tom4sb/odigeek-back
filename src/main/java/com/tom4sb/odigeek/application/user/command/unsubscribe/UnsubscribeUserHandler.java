package com.tom4sb.odigeek.application.user.command.unsubscribe;

import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import com.tom4sb.odigeek.domain.user.model.UserId;
import com.tom4sb.odigeek.domain.user.model.Users;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public final class UnsubscribeUserHandler
    implements CommandHandler<UnsubscribeUser> {

  private final Users users;
  private final Subscriptions subscriptions;

  public UnsubscribeUserHandler(
      final Users users,
      final Subscriptions subscriptions
  ) {
    this.users = users;
    this.subscriptions = subscriptions;
  }

  @Override
  public void handle(final UnsubscribeUser command) {
    final var user = users.findById(new UserId(command.getUserId()))
        .orElseThrow(NoSuchElementException::new);
    final var subscriptionId = new SubscriptionId(command.getSubscriptionId());

    subscriptions.findById(subscriptionId)
        .ifPresent(value -> {
          user.unsubscribe(subscriptionId);
          users.save(user);
        });
  }
}
