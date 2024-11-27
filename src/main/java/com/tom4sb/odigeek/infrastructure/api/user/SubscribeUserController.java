package com.tom4sb.odigeek.infrastructure.api.user;

import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import com.tom4sb.odigeek.application.user.command.subscribe.SubscribeUser;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/user")
@RestController
public class SubscribeUserController {

  private final CommandBus commandBus;

  public SubscribeUserController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PostMapping("/{userId}/subscription/{subscriptionId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void action(
      @PathVariable final UUID userId,
      @PathVariable final UUID subscriptionId
  ) {
    final var command = new SubscribeUser(userId, subscriptionId);

    commandBus.dispatch(command);
  }

}
