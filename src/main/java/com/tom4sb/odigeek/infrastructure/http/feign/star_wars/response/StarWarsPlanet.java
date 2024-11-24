package com.tom4sb.odigeek.infrastructure.http.feign.star_wars.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.SubscriptionContentInfo;

public record StarWarsPlanet(
    String name,
    @JsonProperty("rotation_period") String rotationPeriod,
    @JsonProperty("orbital_period") String orbitalPeriod,
    String diameter,
    String climate,
    String gravity,
    String terrain,
    @JsonProperty("surface_water") String surfaceWater,
    String population
) {

  public SubscriptionContentInfo parseToContentInfo(final ObjectMapper objectMapper) {
    return new SubscriptionContentInfo(objectMapper.convertValue(this, new TypeReference<>() {}));
  }

}
