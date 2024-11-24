package com.tom4sb.odigeek.infrastructure.http.feign.star_wars.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.SubscriptionContentInfo;

public record StarWarsPerson(
    String name,
    String height,
    String mass,
    @JsonProperty("hair_color") String hairColor,
    @JsonProperty("skin_color") String skinColor,
    @JsonProperty("eye_color") String eyeColor,
    @JsonProperty("birth_year") String birthYear,
    String gender
) {

  public SubscriptionContentInfo parseToContentInfo(final ObjectMapper objectMapper) {
    return new SubscriptionContentInfo(objectMapper.convertValue(this, new TypeReference<>() {}));
  }

}
