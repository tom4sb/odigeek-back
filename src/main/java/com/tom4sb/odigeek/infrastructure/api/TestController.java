package com.tom4sb.odigeek.infrastructure.api;

import com.tom4sb.odigeek.domain.subscription.command.create.CreateSubscription;
import com.tom4sb.odigeek.domain.subscription.command.create.CreateSubscriptionHandler;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionCategories.SubscriptionCategoryValue;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice.CurrencyCode;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController { // TODO remove this controller

  private final CreateSubscriptionHandler handler;

  public TestController(final CreateSubscriptionHandler handler) {
    this.handler = handler;
  }

  @GetMapping("/test")
  public void test(@RequestParam final String title) {
    final var command = new CreateSubscription(
        title,
        List.of(SubscriptionCategoryValue.ANIME.name()),
        5.0,
        CurrencyCode.USD.name(),
        "Subscription description"
    );
    handler.handle(command);
  }

}
