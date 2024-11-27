package com.tom4sb.odigeek.infrastructure.domain.offer;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.offer.model.OfferId;
import com.tom4sb.odigeek.domain.offer.model.Offers;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryOffers
    implements Offers {

  private static final Map<OfferId, Offer> offers = new HashMap<>();

  @Override
  public void save(final Offer offer) {
    offers.put(offer.id(), offer);
  }

  @Override
  public List<Offer> findByPeriodStart(final Instant start) {
    final var startDate = LocalDate.ofInstant(start, ZoneId.systemDefault());
    return offers.values().stream()
        .filter(offer ->
            LocalDate.ofInstant(offer.period().start(), ZoneId.systemDefault()).isEqual(startDate))
        .collect(Collectors.toList());
  }

}
