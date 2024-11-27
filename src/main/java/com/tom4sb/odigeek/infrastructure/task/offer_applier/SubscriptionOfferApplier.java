package com.tom4sb.odigeek.infrastructure.task.offer_applier;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice;
import java.util.List;

public interface SubscriptionOfferApplier {

  void apply(List<Offer> offersToApply, List<Subscription> allSubscriptions);

  default void applyOffer(final Offer offer, final List<Subscription> subscriptions) {
    final var offerMultiplier = offer.rule().getMultiplier();
    final var offerCurrency = offer.rule().getCurrency();

    subscriptions.stream()
        .filter(subscription -> subscription.getPrice().getCurrency().equals(offerCurrency))
        .forEach(subscription -> subscription.updatePrice(subscriptionPriceWithOffer(subscription, offerMultiplier)));
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
