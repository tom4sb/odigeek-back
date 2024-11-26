package com.tom4sb.odigeek.domain.shared.model;

import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierName.DRAGON_BALL;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierName.STAR_WARS;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierOption.HUMANS;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierOption.PEOPLE;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierOption.PLANETS;
import static com.tom4sb.odigeek.domain.shared.model.SubscriptionTitleValue.SupplierOption.SAIYANS;

import java.util.Optional;

public enum SubscriptionTitleValue {
  DRAGON_BALL_HUMANS(DRAGON_BALL, HUMANS),
  DRAGON_BALL_SAIYANS(DRAGON_BALL, SAIYANS),
  STAR_WARS_PEOPLE(STAR_WARS, PEOPLE),
  STAR_WARS_PLANETS(STAR_WARS, PLANETS);


  private final SupplierName supplierName;
  private final SupplierOption supplierOption;

  SubscriptionTitleValue(
      final SupplierName supplierName,
      final SupplierOption supplierOption
  ) {
    this.supplierName = supplierName;
    this.supplierOption = supplierOption;
  }

  public SupplierName getSupplierName() {
    return supplierName;
  }

  public SupplierOption getSupplierOption() {
    return supplierOption;
  }

  public static Optional<SubscriptionTitleValue> create(final String titleName) {
    try {
      return Optional.of(SubscriptionTitleValue.valueOf(titleName));
    } catch (final IllegalArgumentException | NullPointerException e) {
      return Optional.empty();
    }
  }


  public enum SupplierName {
    DRAGON_BALL,
    STAR_WARS
  }

  public enum SupplierOption {
    HUMANS,
    PEOPLE,
    PLANETS,
    SAIYANS
  }

}
