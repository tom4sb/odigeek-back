package com.tom4sb.odigeek.application.user.query.view_subscriptions_by_id;

import com.tom4sb.odigeek.application.shared.messaging.QueryHandler;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import com.tom4sb.odigeek.domain.user.model.UserId;
import com.tom4sb.odigeek.domain.user.model.Users;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public final class ViewSubscriptionsByIdHandler
    implements QueryHandler<ViewSubscriptionsById, List<Subscription>> {

  private final Users users;
  private final Subscriptions subscriptions;

  public ViewSubscriptionsByIdHandler(
      final Users users,
      final Subscriptions subscriptions
  ) {
    this.users = users;
    this.subscriptions = subscriptions;
  }

  @Override
  public List<Subscription> ask(final ViewSubscriptionsById query) {
    final var user = users.findById(new UserId(query.getUserId()))
        .orElseThrow(NoSuchElementException::new);

    return user.subscriptions().getValues().stream()
        .map(subscriptions::findById)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
  }

}
