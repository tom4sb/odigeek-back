package com.tom4sb.odigeek.infrastructure.http.feign.dragon_ball.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.SubscriptionContentInfo;

public record DragonBallCharacter(
    String name,
    String ki,
    String maxKi,
    String race,
    String gender,
    String description,
    String affiliation
) {

  public SubscriptionContentInfo parseToContentInfo(final ObjectMapper objectMapper) {
    return new SubscriptionContentInfo(objectMapper.convertValue(this, new TypeReference<>() {}));
  }

}
