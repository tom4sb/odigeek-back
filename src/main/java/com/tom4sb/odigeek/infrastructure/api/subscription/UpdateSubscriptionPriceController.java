package com.tom4sb.odigeek.infrastructure.api.subscription;

import com.tom4sb.odigeek.application.subscription.command.update_price.UpdateSubscriptionPrice;
import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/subscription")
@RestController
public class UpdateSubscriptionPriceController {

  private final CommandBus commandBus;

  public UpdateSubscriptionPriceController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PatchMapping
  @ResponseStatus(HttpStatus.OK) // TODO if fails, must return 304 (Not Modified), 400 (Bad Request), or 422 (Unprocessable Entity)
  public void action(@RequestBody final UpdateSubscriptionPriceRequest request) {
    final var command = new UpdateSubscriptionPrice(
        UUID.fromString(request.id),
        request.priceAmount,
        request.priceCurrency
    );

    commandBus.dispatch(command);
  }

  static final class UpdateSubscriptionPriceRequest {
    public String id;
    public Double priceAmount;
    public String priceCurrency;
  }

}
