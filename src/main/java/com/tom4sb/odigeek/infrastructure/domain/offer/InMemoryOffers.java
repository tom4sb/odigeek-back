package com.tom4sb.odigeek.infrastructure.domain.offer;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.offer.model.OfferId;
import com.tom4sb.odigeek.domain.offer.model.Offers;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryOffers
    implements Offers {

  private static final Logger log = LoggerFactory.getLogger(InMemoryOffers.class);
  private static final Map<OfferId, Offer> offers = new HashMap<>();

  @Override
  public void save(final Offer offer) {
    offers.put(offer.id(), offer);

    log.info("Offer with ID {}, title {} and between {} and {} saved!",
        offer.id().value(),
        offer.title().value(),
        offer.period().start(),
        offer.period().end()
    );
  }

}
