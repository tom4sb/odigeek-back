package com.tom4sb.odigeek.domain.subscription.model;

public record Subscription(
    SubscriptionId id,
    SubscriptionTitle title,
    SubscriptionCategory category,
    SubscriptionPrice price,
    SubscriptionDescription description,
    SubscriptionContent content
) {

  public static Subscription create(
      final SubscriptionId id,
      final SubscriptionTitle title,
      final SubscriptionCategory category,
      final SubscriptionPrice price,
      final SubscriptionDescription description,
      final SubscriptionContent content
  ) {
    return new Subscription(id, title, category, price, description, content);
  }

}
