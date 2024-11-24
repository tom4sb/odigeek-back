package com.tom4sb.odigeek.domain.subscription.model;

import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierName.DRAGON_BALL;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierName.STAR_WARS;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption.HUMANS;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption.PEOPLE;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption.PLANETS;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption.SAIYANS;

import java.util.Objects;

public class SubscriptionTitle {

  private final SubscriptionTitleValue value;

  public SubscriptionTitle(final String titleName) {
    if (Objects.isNull(titleName)) {
      throw new IllegalArgumentException("Subscription title cannot be null");
    }
    this.value = buildValue(titleName);
  }

  public SubscriptionTitleValue getValue() {
    return value;
  }

  private SubscriptionTitleValue buildValue(final String titleName) {
    try {
      return SubscriptionTitleValue.valueOf(titleName);
    } catch (final IllegalArgumentException e) {
      throw new IllegalArgumentException("Subscription title does not exist");
    }
  }


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

}
