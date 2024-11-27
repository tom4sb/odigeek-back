package com.tom4sb.odigeek.infrastructure.domain.subscription;

import com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemorySubscriptions
    implements Subscriptions {

  private Map<SubscriptionId, Subscription> subscriptions = new HashMap<>();

  @Override
  public void save(final Subscription subscription) {
    subscriptions.put(subscription.getId(), subscription);
  }

  @Override
  public List<Subscription> getAll() {
    return subscriptions.values().stream().toList();
  }

  @Override
  public Optional<Subscription> findById(final SubscriptionId id) {
    return Optional.ofNullable(subscriptions.get(id));
  }

  @Override
  public Optional<Subscription> findByTitle(final SubscriptionTitle title) {
    return subscriptions.values().stream()
        .filter(subscription -> subscription.getTitle().equals(title))
        .findFirst();
  }

  @Override
  public List<Subscription> findByCategory(final SubscriptionCategoryValue categoryValue) {
    return subscriptions.values().stream()
        .filter(subscription -> subscription.getCategories().getValues().contains(categoryValue))
        .collect(Collectors.toList());
  }

  public Map<SubscriptionId, Subscription> getSubscriptions() {
    return subscriptions;
  }

  public void setSubscriptions(final Map<SubscriptionId, Subscription> subscriptions) {
    this.subscriptions = subscriptions;
  }

}
