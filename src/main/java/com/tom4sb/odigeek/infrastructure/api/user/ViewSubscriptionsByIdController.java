package com.tom4sb.odigeek.infrastructure.api.user;

import com.tom4sb.odigeek.application.shared.messaging.QueryBus;
import com.tom4sb.odigeek.application.user.query.view_subscriptions_by_id.ViewSubscriptionsById;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/user")
@RestController
public class ViewSubscriptionsByIdController {

  private final QueryBus queryBus;

  public ViewSubscriptionsByIdController(final QueryBus queryBus) {
    this.queryBus = queryBus;
  }

  @GetMapping("/{userId}/subscription")
  @ResponseStatus(HttpStatus.OK)
  public List<Subscription> action(@PathVariable final UUID userId) {
    final var query = new ViewSubscriptionsById(userId);

    return queryBus.ask(query);
  }

}
