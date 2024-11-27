package com.tom4sb.odigeek.infrastructure.api.offer;

import com.tom4sb.odigeek.application.offer.command.create.CreateOffer;
import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/offer")
@RestController
public class CreateOfferController {

  private final CommandBus commandBus;

  public CreateOfferController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void action(@RequestBody final CreateOfferRequest request) {
    final var command = new CreateOffer(
        request.title,
        request.description,
        request.ruleMultiplier,
        request.ruleCurrency,
        request.scope,
        request.scopeTitle,
        request.scopeCategory,
        request.periodStart,
        request.periodEnd
    );

    commandBus.dispatch(command);
  }

  static final class CreateOfferRequest {
    public String title;
    public String description;
    public Double ruleMultiplier;
    public String ruleCurrency;
    public String scope;
    public String scopeTitle;
    public String scopeCategory;
    public String periodStart;
    public String periodEnd;
  }

}
