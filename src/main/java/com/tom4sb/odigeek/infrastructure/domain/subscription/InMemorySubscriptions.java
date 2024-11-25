package com.tom4sb.odigeek.infrastructure.domain.subscription;

import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class InMemorySubscriptions
    implements Subscriptions {

  private static final Logger log = LoggerFactory.getLogger(InMemorySubscriptions.class);
  private static final Map<SubscriptionId, Subscription> subscriptions = new HashMap<>();

  @Override
  public void save(final Subscription subscription) {
    final var savedSubscription = Optional.ofNullable(
        subscriptions.putIfAbsent(subscription.id(), subscription)
    );

    savedSubscription.ifPresentOrElse(
        value -> log.info("Subscription with ID {} already exists!", value.id().value()),
        () -> log.info("Subscription with ID {} and title {} saved!",
            subscription.id().value(), subscription.title().getValue())
    );
  }

  @Override
  public List<Subscription> findAll() {
    return subscriptions.values().stream().toList();
  }

}
