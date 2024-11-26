package com.tom4sb.odigeek.domain.offer.model;

import java.time.Instant;
import java.util.Objects;

public record OfferPeriod(
    Instant start,
    Instant end
) {

  public OfferPeriod {
    if (Objects.isNull(start) || Objects.isNull(end)) {
      throw new IllegalArgumentException("Offer period start and end cannot be null");
    }
    if (end.isBefore(start)) {
      throw new IllegalArgumentException("Offer period end cannot be before start");
    }
  }

}
