package com.tom4sb.odigeek.infrastructure.task.offer_applier;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionOfferByTitleApplier
    implements SubscriptionOfferApplier {

  @Override
  public void apply(final List<Offer> offersToApply, final List<Subscription> allSubscriptions) {
    final var offerScopeTitles = offersToApply.stream()
        .map(offer -> offer.scope().getTitle().get().name())
        .toList();
    final var subscriptionsByTitle = filterSubscriptionsByOfferScopeTitles(offerScopeTitles, allSubscriptions).stream()
        .collect(Collectors.groupingBy(subscription -> subscription.getTitle().getValue().name()));

    offersToApply.forEach(offer -> applyOffer(offer, subscriptionsByTitle.get(offer.scope().getTitle().get().name())));
  }

  public List<Subscription> filterSubscriptionsByOfferScopeTitles(
      final List<String> offerScopeTitles,
      final List<Subscription> subscriptions
  ) {
    return subscriptions.stream()
        .filter(subscription -> offerScopeTitles.stream()
            .anyMatch(offerScopeTitle -> offerScopeTitle.equals(subscription.getTitle().getValue().name())))
        .collect(Collectors.toList());
  }

}
