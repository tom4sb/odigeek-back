package com.tom4sb.odigeek.domain.offer.model;

import java.time.Instant;
import java.util.List;

public interface Offers {

  void save(Offer offer);

  List<Offer> findByPeriodStart(Instant start);

}
