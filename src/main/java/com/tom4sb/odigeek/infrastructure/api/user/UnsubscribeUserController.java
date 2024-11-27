package com.tom4sb.odigeek.infrastructure.api.user;

import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import com.tom4sb.odigeek.application.user.command.subscribe.SubscribeUser;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/user")
@RestController
public class UnsubscribeUserController {

  private final CommandBus commandBus;

  public UnsubscribeUserController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @DeleteMapping("/{userId}/subscription/{subscriptionId}")
  @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content as it's an update
  public void action(
      @PathVariable final UUID userId,
      @PathVariable final UUID subscriptionId
  ) {
    final var command = new SubscribeUser(userId, subscriptionId);

    commandBus.dispatch(command);
  }

}
