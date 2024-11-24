package com.tom4sb.odigeek.domain.subscription.model;

public record Subscription(
    SubscriptionId id,
    SubscriptionTitle title,
    SubscriptionCategories categories,
    SubscriptionPrice price,
    SubscriptionDescription description,
    SubscriptionContent content
) {

  public static Subscription create(
      final SubscriptionId id,
      final SubscriptionTitle title,
      final SubscriptionCategories categories,
      final SubscriptionPrice price,
      final SubscriptionDescription description,
      final SubscriptionContent content
  ) {
    return new Subscription(id, title, categories, price, description, content);
  }

}
