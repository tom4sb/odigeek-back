package com.tom4sb.odigeek.application.subscription.command.update_status;

import com.tom4sb.odigeek.application.shared.messaging.Command;
import java.util.UUID;

public final class UpdateSubscriptionStatus
    extends Command {

  private final UUID id;
  private final Boolean status;

  public UpdateSubscriptionStatus(
      final UUID id,
      final Boolean status
  ) {
    this.id = id;
    this.status = status;
  }

  public UUID getId() {
    return id;
  }

  public Boolean getStatus() {
    return status;
  }

}
