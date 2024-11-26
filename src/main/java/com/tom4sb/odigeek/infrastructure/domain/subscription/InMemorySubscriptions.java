package com.tom4sb.odigeek.infrastructure.domain.subscription;

import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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
    subscriptions.put(subscription.getId(), subscription);

    log.info("Subscription with ID {}, title {}, categories {}, and price {} {} saved!",
        subscription.getId().value(),
        subscription.getTitle().getValue(),
        String.join("|", subscription.getCategories().getValues().stream()
            .map(Enum::name)
            .toList()),
        subscription.getPrice().getAmount(),
        subscription.getPrice().getCurrency().value()
    );
  }

  @Override
  public List<Subscription> getAll() {
    return subscriptions.values().stream().toList();
  }

  @Override
  public Optional<Subscription> get(final SubscriptionId id) {
    return Optional.ofNullable(subscriptions.get(id));
  }

}
