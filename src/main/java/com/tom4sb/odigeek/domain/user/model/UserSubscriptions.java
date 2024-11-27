package com.tom4sb.odigeek.domain.user.model;

import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import java.util.List;

public class UserSubscriptions {

  private List<SubscriptionId> values;

  public UserSubscriptions(final List<SubscriptionId> values) {
    this.values = values;
  }

  public List<SubscriptionId> getValues() {
    return values;
  }

  public void enroll(final SubscriptionId subscriptionId) {
    values.add(subscriptionId);
  }

}
