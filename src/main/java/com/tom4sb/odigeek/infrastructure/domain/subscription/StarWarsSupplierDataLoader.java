package com.tom4sb.odigeek.infrastructure.domain.subscription;

import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierOption.PEOPLE;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierOption.PLANETS;

import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.infrastructure.http.feign.star_wars.FeignStarWarsHttpClient;
import java.util.Collections;
import org.springframework.stereotype.Component;

@Component
public class StarWarsSupplierDataLoader
    implements SupplierDataLoader {

  private final FeignStarWarsHttpClient httpClient;

  public StarWarsSupplierDataLoader(final FeignStarWarsHttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public SubscriptionContent load(final SubscriptionTitle title) {
    if (PEOPLE == title.getValue().getSupplierOption()) {
      return httpClient.loadPeople().parseToContent();
    } else if (PLANETS == title.getValue().getSupplierOption()) {
      return httpClient.loadPlanets().parseToContent();
    } else {
      return new SubscriptionContent(Collections.emptyMap());
    }
  }

}
