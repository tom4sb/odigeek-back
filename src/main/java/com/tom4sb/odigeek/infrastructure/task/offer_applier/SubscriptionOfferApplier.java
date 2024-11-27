package com.tom4sb.odigeek.infrastructure.task.offer_applier;

import com.tom4sb.odigeek.application.subscription.command.update_status.UpdateSubscriptionStatusHandler;
import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SubscriptionOfferApplier {

  Logger log = LoggerFactory.getLogger(SubscriptionOfferApplier.class);

  void apply(List<Offer> offersToApply, List<Subscription> allSubscriptions);

  default void applyOffer(final Offer offer, final List<Subscription> subscriptions) {
    log.info("Applying {} offer...", offer.title().value());

    final var offerMultiplier = offer.rule().getMultiplier();
    final var offerCurrency = offer.rule().getCurrency();

    subscriptions.stream()
        .filter(subscription -> subscription.getPrice().getCurrency().equals(offerCurrency))
        .forEach(subscription -> subscription.updatePrice(subscriptionPriceWithOffer(subscription, offerMultiplier)));

    log.info("{} offer applied!", offer.title().value());
  }

  default SubscriptionPrice subscriptionPriceWithOffer(
      final Subscription subscription,
      final Double offerMultiplier
  ) {
    return new SubscriptionPrice(
        subscription.getPrice().getAmount() * offerMultiplier,
        subscription.getPrice().getCurrency().value().name()
    );
  }

}
