package com.tom4sb.odigeek.domain.offer.model;

import static com.tom4sb.odigeek.domain.offer.model.OfferScope.OfferScopeValue.CATEGORY;
import static com.tom4sb.odigeek.domain.offer.model.OfferScope.OfferScopeValue.TITLE;

import com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue;
import com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue;
import java.util.Objects;
import java.util.Optional;

public class OfferScope {

  private final OfferScopeValue value;
  private final Optional<SubscriptionTitleValue> title;
  private final Optional<SubscriptionCategoryValue> category;

  public OfferScope(final String scopeName, final String titleName, final String categoryName) {
    if (Objects.isNull(scopeName)) {
      throw new IllegalArgumentException("Offer scope cannot be null");
    }
    this.value = OfferScopeValue.create(scopeName)
        .orElseThrow(() -> new IllegalArgumentException("Offer scope does not exist"));

    if (value == TITLE && Objects.isNull(titleName)) {
      throw new IllegalArgumentException("Offer scope title cannot be null");
    }
    if (value == CATEGORY && Objects.isNull(categoryName)) {
      throw new IllegalArgumentException("Offer scope category cannot be null");
    }
    this.title = SubscriptionTitleValue.create(titleName);
    this.category = SubscriptionCategoryValue.create(categoryName);
  }

  public OfferScopeValue getValue() {
    return value;
  }

  public Optional<SubscriptionTitleValue> getTitle() {
    return title;
  }

  public Optional<SubscriptionCategoryValue> getCategory() {
    return category;
  }


  public enum OfferScopeValue {
    CATEGORY,
    CATALOG,
    TITLE;


    public static Optional<OfferScopeValue> create(final String scopeName) {
      try {
        return Optional.of(OfferScopeValue.valueOf(scopeName));
      } catch (final IllegalArgumentException e) {
        return Optional.empty();
      }
    }

  }

  @Override
  public String toString() {
    return "OfferScope{" +
        "value=" + value +
        ", title=" + title +
        ", category=" + category +
        '}';
  }

}
