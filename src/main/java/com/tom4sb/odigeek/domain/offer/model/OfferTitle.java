package com.tom4sb.odigeek.domain.offer.model;

import java.util.Objects;

public record OfferTitle(
    String value
) {

  public OfferTitle {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("Offer title cannot be null");
    }
  }

}
