package com.tom4sb.odigeek.infrastructure.http.feign.star_wars;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.tom4sb.odigeek.infrastructure.http.feign.star_wars.response.StarWarsPeopleResponse;
import com.tom4sb.odigeek.infrastructure.http.feign.star_wars.response.StarWarsPlanetsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    value = "starWarsHttpClient",
    url = "${subscriptions.suppliers.star-wars.api-base-url}"
)
public interface FeignStarWarsHttpClient {

  @GetMapping(
      value = "/people",
      produces = APPLICATION_JSON_VALUE,
      consumes = APPLICATION_JSON_VALUE
  )
  StarWarsPeopleResponse loadPeople();

  @GetMapping(
      value = "/planets",
      produces = APPLICATION_JSON_VALUE,
      consumes = APPLICATION_JSON_VALUE
  )
  StarWarsPlanetsResponse loadPlanets();

}
