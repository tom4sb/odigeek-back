package com.tom4sb.odigeek.domain.subscription.model;

import java.util.List;
import java.util.Optional;

public interface Subscriptions {

  void save(Subscription subscription);

  List<Subscription> getAll();

  Optional<Subscription> get(SubscriptionId id);

}
