package com.tom4sb.odigeek.application.user.query.view_subscriptions_by_id;

import com.tom4sb.odigeek.application.shared.messaging.Query;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import java.util.List;
import java.util.UUID;

public final class ViewSubscriptionsById
    extends Query<List<Subscription>> {

  private final UUID userId;

  public ViewSubscriptionsById(final UUID userId) {
    this.userId = userId;
  }

  public UUID getUserId() {
    return userId;
  }

}
