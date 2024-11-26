package com.tom4sb.odigeek.application.subscription.query.view_all;

import com.tom4sb.odigeek.application.shared.messaging.QueryHandler;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public final class ViewAllSubscriptionsHandler
    implements QueryHandler<ViewAllSubscriptions, List<Subscription>> {

  private final Subscriptions subscriptions;

  public ViewAllSubscriptionsHandler(final Subscriptions subscriptions) {
    this.subscriptions = subscriptions;
  }

  @Override
  public List<Subscription> ask(final ViewAllSubscriptions query) {
    return subscriptions.getAll();
  }

}
