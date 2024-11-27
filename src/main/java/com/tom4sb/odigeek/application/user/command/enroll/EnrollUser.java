package com.tom4sb.odigeek.application.user.command.enroll;

import com.tom4sb.odigeek.application.shared.messaging.Command;
import java.util.UUID;

public final class EnrollUser
    extends Command {

  private final UUID userId;
  private final UUID subscriptionId;

  public EnrollUser(
      final UUID userId,
      final UUID subscriptionId
  ) {
    this.userId = userId;
    this.subscriptionId = subscriptionId;
  }

  public UUID getUserId() {
    return userId;
  }

  public UUID getSubscriptionId() {
    return subscriptionId;
  }

}
