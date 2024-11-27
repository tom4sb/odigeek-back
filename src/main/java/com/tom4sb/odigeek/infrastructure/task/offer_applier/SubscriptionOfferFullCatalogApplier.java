package com.tom4sb.odigeek.infrastructure.task.offer_applier;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import java.util.List;

public class SubscriptionOfferFullCatalogApplier
    implements SubscriptionOfferApplier {

  @Override
  public void apply(final List<Offer> offersToApply, final List<Subscription> allSubscriptions) {
    offersToApply.forEach(offer -> applyOffer(offer, allSubscriptions));
  }

}
