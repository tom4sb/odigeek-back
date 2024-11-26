package com.tom4sb.odigeek.domain.offer.model;

import java.util.Objects;
import java.util.UUID;

public record OfferId(
    UUID value
) {

  public OfferId {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("Offer ID cannot be null");
    }
  }

}
