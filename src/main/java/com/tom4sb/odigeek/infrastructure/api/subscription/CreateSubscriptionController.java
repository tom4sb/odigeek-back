package com.tom4sb.odigeek.infrastructure.api.subscription;

import com.tom4sb.odigeek.application.subscription.command.create.CreateSubscription;
import com.tom4sb.odigeek.domain.shared.messaging.CommandBus;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api")
@RestController
public class CreateSubscriptionController {

  private final CommandBus commandBus;

  public CreateSubscriptionController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PostMapping("/subscription")
  @ResponseStatus(HttpStatus.CREATED) // TODO must return 403 if exists
  public void action(@RequestBody final CreateSubscriptionRequest request) {
    final var command = new CreateSubscription(
        UUID.fromString(request.id),
        request.title,
        request.categories,
        request.price,
        request.currency,
        request.description
    );

    commandBus.dispatch(command);
  }

  static final class CreateSubscriptionRequest {
    public String id;
    public String title;
    public List<String> categories;
    public Double price;
    public String currency;
    public String description;
  }

}
