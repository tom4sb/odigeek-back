package com.tom4sb.odigeek.infrastructure.http.feign.star_wars.response;

import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.ContentFamily.DATA;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.ContentFamily.FIGURES;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.SubscriptionContentInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public record StarWarsPlanetsResponse(
    @JsonProperty("results") List<StarWarsPlanet> planets
) {

  public SubscriptionContent parseToContent() {
    return new SubscriptionContent(
        Map.of(
            DATA, buildDataContentInfo(planets),
            FIGURES, buildFiguresContentInfo()
        )
    );
  }

  private List<SubscriptionContentInfo> buildDataContentInfo(final List<StarWarsPlanet> planets) {
    final var objectMapper = new ObjectMapper();
    return planets.stream()
        .map(planet -> planet.parseToContentInfo(objectMapper))
        .toList();
  }

  private List<SubscriptionContentInfo> buildFiguresContentInfo() {
    return Collections.emptyList(); // TODO Fill when figures are acquired
  }

}
