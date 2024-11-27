package com.tom4sb.odigeek.domain.subscription.model;

import com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue;
import java.util.List;
import java.util.Optional;

public interface Subscriptions {

  void save(Subscription subscription);

  List<Subscription> getAll();

  Optional<Subscription> findById(SubscriptionId id);

  Optional<Subscription> findByTitle(SubscriptionTitle title);

  List<Subscription> findByCategory(SubscriptionCategoryValue categoryValue);

}
