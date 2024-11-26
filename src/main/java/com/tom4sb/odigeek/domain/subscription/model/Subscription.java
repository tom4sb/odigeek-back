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

  private Subscription(
      final SubscriptionId id,
      final SubscriptionTitle title,
      final SubscriptionCategories categories,
      final SubscriptionPrice price,
      final SubscriptionDescription description,
      final SubscriptionContent content
  ) {
    this.id = id;
    this.title = title;
    this.categories = categories;
    this.price = price;
    this.description = description;
    this.content = content;
  }

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

  public void updatePrice(final SubscriptionPrice price) {
    this.price = price;
  }

  public void updateContent(final SubscriptionContent content) {
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
          '}';
    }
  }

}
