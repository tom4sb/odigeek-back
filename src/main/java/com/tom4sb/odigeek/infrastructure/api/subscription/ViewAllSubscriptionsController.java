package com.tom4sb.odigeek.infrastructure.api.subscription;

import com.tom4sb.odigeek.application.shared.messaging.QueryBus;
import com.tom4sb.odigeek.application.subscription.query.view_all.ViewAllSubscriptions;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/subscription")
@RestController
public class ViewAllSubscriptionsController {

  private final QueryBus queryBus;

  public ViewAllSubscriptionsController(final QueryBus queryBus) {
    this.queryBus = queryBus;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Subscription> action() {
    final var query = new ViewAllSubscriptions();

    return queryBus.ask(query);
  }

}
