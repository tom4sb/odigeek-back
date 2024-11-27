package com.tom4sb.odigeek.domain.offer.model;

public record Offer(
    OfferId id,
    OfferTitle title,
    OfferDescription description,
    OfferRule rule,
    OfferScope scope,
    OfferPeriod period
) {

  public static Offer create(
      final OfferId id,
      final OfferTitle title,
      final OfferDescription description,
      final OfferRule rule,
      final OfferScope scope,
      final OfferPeriod period
  ) {
    return new Offer(id, title, description, rule, scope, period);
  }

  @Override
  public String toString() {
    return "Offer{" +
        "id=" + id +
        ", title=" + title +
        ", description=" + description +
        ", rule=" + rule +
        ", scope=" + scope +
        ", period=" + period +
        '}';
  }

}
