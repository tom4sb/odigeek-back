package com.tom4sb.odigeek.infrastructure.domain.subscription;

import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.DRAGON_BALL_HUMANS;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.STAR_WARS_PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import java.util.Map;
import org.junit.jupiter.api.Test;

class InMemorySubscriptionsTest {

  @Test
  void should_return_subscription_when_title_exists() {
    final var title = new SubscriptionTitle(DRAGON_BALL_HUMANS.name());
    final var subscriptionId = mock(SubscriptionId.class);
    final var subscription = mock(Subscription.class);
    final var subscriptions = Map.of(subscriptionId, subscription);
    final var inMemorySubscriptions = new InMemorySubscriptions();
    inMemorySubscriptions.setSubscriptions(subscriptions);

    when(subscription.getTitle())
        .thenReturn(title);

    final var subscriptionFound = inMemorySubscriptions.findByTitle(title);

    assertTrue(subscriptionFound.isPresent());
    assertEquals(subscription, subscriptionFound.get());
  }

  @Test
  void should_return_subscription_when_title_does_not_exist() {
    final var title = new SubscriptionTitle(DRAGON_BALL_HUMANS.name());
    final var otherTitle = new SubscriptionTitle(STAR_WARS_PEOPLE.name());
    final var subscriptionId = mock(SubscriptionId.class);
    final var subscription = mock(Subscription.class);
    final var subscriptions = Map.of(subscriptionId, subscription);
    final var inMemorySubscriptions = new InMemorySubscriptions();
    inMemorySubscriptions.setSubscriptions(subscriptions);

    when(subscription.getTitle())
        .thenReturn(otherTitle);

    final var subscriptionFound = inMemorySubscriptions.findByTitle(title);

    assertTrue(subscriptionFound.isEmpty());
  }

}
