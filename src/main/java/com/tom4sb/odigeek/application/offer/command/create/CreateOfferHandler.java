package com.tom4sb.odigeek.application.offer.command.create;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.offer.model.OfferDescription;
import com.tom4sb.odigeek.domain.offer.model.OfferId;
import com.tom4sb.odigeek.domain.offer.model.OfferPeriod;
import com.tom4sb.odigeek.domain.offer.model.OfferRule;
import com.tom4sb.odigeek.domain.offer.model.OfferScope;
import com.tom4sb.odigeek.domain.offer.model.OfferTitle;
import com.tom4sb.odigeek.domain.offer.model.Offers;
import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.application.shared.provider.IdProvider;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public final class CreateOfferHandler
    implements CommandHandler<CreateOffer> {

  private final IdProvider<UUID> idProvider;
  private final Offers offers;

  public CreateOfferHandler(
      final IdProvider<UUID> idProvider,
      final Offers offers
  ) {
    this.idProvider = idProvider;
    this.offers = offers;
  }

  @Override
  public void handle(final CreateOffer command) {
    final var id = new OfferId(idProvider.provide());
    final var title = new OfferTitle(command.getTitle());
    final var description = new OfferDescription(command.getDescription());
    final var rule = new OfferRule(command.getRuleMultiplier(), command.getRuleCurrency());
    final var scope = new OfferScope(
        command.getScope(),
        command.getScopeTitle(),
        command.getScopeCategory()
    );
    final var period = new OfferPeriod(
        parseToInstant(command.getPeriodStart()),
        parseToInstant(command.getPeriodEnd())
    );

    final var offer = Offer.create(
        id,
        title,
        description,
        rule,
        scope,
        period
    );

    offers.save(offer);
  }

  private Instant parseToInstant(final String dateAsString) {
    return LocalDate.parse(dateAsString)
        .atStartOfDay(ZoneOffset.UTC)
        .toInstant();
  }

}
