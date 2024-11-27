package com.tom4sb.odigeek.domain.user.model;

import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import java.util.ArrayList;

public record User(
    UserId id,
    UserName username,
    UserPassword password,
    UserFullName fullName,
    UserEmail email,
    UserPhone phone,
    UserAge age,
    UserHomeCity homeCity,
    UserBankDetails bankDetails,
    UserRole role,
    UserSubscriptions subscriptions
) {

  public static User create(
      final UserId id,
      final UserName username,
      final UserPassword password,
      final UserFullName fullName,
      final UserEmail email,
      final UserPhone phone,
      final UserAge age,
      final UserHomeCity homeCity,
      final UserBankDetails bankDetails,
      final UserRole role
  ) {
    return new User(
        id,
        username,
        password,
        fullName,
        email,
        phone,
        age,
        homeCity,
        bankDetails,
        role,
        new UserSubscriptions(new ArrayList<>())
    );
  }

  public void subscribe(final SubscriptionId subscriptionId) {
    subscriptions.subscribe(subscriptionId);
  }

}
