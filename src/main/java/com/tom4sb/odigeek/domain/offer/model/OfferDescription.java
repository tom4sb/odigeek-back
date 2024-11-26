package com.tom4sb.odigeek.domain.offer.model;

import java.util.Objects;

public record OfferDescription(
    String value
) {

  public OfferDescription {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("Offer description cannot be null");
    }
  }

}
