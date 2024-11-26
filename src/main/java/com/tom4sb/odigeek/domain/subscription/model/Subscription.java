package com.tom4sb.odigeek.domain.subscription.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Subscription {

  private final SubscriptionId id;
  private final SubscriptionTitle title;
  private final SubscriptionCategories categories;
  private SubscriptionPrice price;
  private final SubscriptionDescription description;
  private SubscriptionContent content;
  private final SubscriptionStatus status;

  private Subscription(
      final SubscriptionId id,
      final SubscriptionTitle title,
      final SubscriptionCategories categories,
      final SubscriptionPrice price,
      final SubscriptionDescription description,
      final SubscriptionContent content,
      final SubscriptionStatus status
  ) {
    this.id = id;
    this.title = title;
    this.categories = categories;
    this.price = price;
    this.description = description;
    this.content = content;
    this.status = status;
  }

  public static Subscription create(
      final SubscriptionId id,
      final SubscriptionTitle title,
      final SubscriptionCategories categories,
      final SubscriptionPrice price,
      final SubscriptionDescription description,
      final SubscriptionContent content,
      final SubscriptionStatus status
  ) {
    return new Subscription(id, title, categories, price, description, content, status);
  }

  public SubscriptionId getId() {
    return id;
  }

  public SubscriptionTitle getTitle() {
    return title;
  }

  public SubscriptionCategories getCategories() {
    return categories;
  }

  public SubscriptionPrice getPrice() {
    return price;
  }

  public SubscriptionDescription getDescription() {
    return description;
  }

  public SubscriptionContent getContent() {
    return content;
  }

  public SubscriptionStatus getStatus() {
    return status;
  }

  public void updatePrice(final SubscriptionPrice price) {
    if (status.isInactive()) {
      return;
    }

    this.price = price;
  }

  public void updateContent(final SubscriptionContent content) {
    if (status.isInactive()) {
      return;
    }

    this.content = content;
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
          ", status=" + status +
          '}';
    }
  }

}
