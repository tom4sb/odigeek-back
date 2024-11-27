package com.tom4sb.odigeek.infrastructure.task.offer_applier;

import static com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue.ANIME;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue.LIVING_BEINGS;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue.SPACE_OPERA;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubscriptionOfferByCategoryApplier
    implements SubscriptionOfferApplier {

  @Override
  public void apply(final List<Offer> offersToApply, final List<Subscription> allSubscriptions) {
    final var offerScopeCategories = offersToApply.stream()
        .map(offer -> offer.scope().getCategory().get().name())
        .toList();
    final var filteredSubscriptions = filterSubscriptionsByOfferScopeCategory(offerScopeCategories, allSubscriptions);
    // TODO Fix this
    final var subscriptionsByCategory = Map.of(
        ANIME.name(), subscriptionsWithCategory(ANIME, filteredSubscriptions),
        LIVING_BEINGS.name(), subscriptionsWithCategory(LIVING_BEINGS, filteredSubscriptions),
        SPACE_OPERA.name(), subscriptionsWithCategory(SPACE_OPERA, filteredSubscriptions)
    );

    offersToApply.forEach(offer -> applyOffer(offer, subscriptionsByCategory.get(offer.scope().getCategory().get().name())));
  }

  public List<Subscription> filterSubscriptionsByOfferScopeCategory(
      final List<String> offerScopeCategories,
      final List<Subscription> subscriptions
  ) {
    return subscriptions.stream()
        .filter(subscription -> offerScopeCategories.stream()
            .anyMatch(
                offerScopeCategory ->
                    subscription.getCategories().getValues().contains(SubscriptionCategoryValue.valueOf(offerScopeCategory))))
        .collect(Collectors.toList());
  }

  public List<Subscription> subscriptionsWithCategory(
      final SubscriptionCategoryValue category,
      final List<Subscription> filteredSubscriptions
  ) {
    return filteredSubscriptions.stream()
        .filter(subscription -> subscription.getCategories().getValues().contains(category))
        .toList();
  }

}
