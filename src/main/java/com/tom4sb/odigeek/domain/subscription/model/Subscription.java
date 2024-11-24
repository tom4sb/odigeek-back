package com.tom4sb.odigeek.domain.subscription.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  @Override
  public String toString() {
    try {
      return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (final JsonProcessingException e) {
      return "Subscription{" +
          "id=" + id +
          ", title=" + title +
          ", categories=" + categories +
          ", price=" + price +
          ", description=" + description +
          ", content=" + content +
          '}';
    }
  }

}
