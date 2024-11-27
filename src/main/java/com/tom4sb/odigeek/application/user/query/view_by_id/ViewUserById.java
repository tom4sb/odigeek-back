package com.tom4sb.odigeek.application.user.query.view_by_id;

import com.tom4sb.odigeek.application.shared.messaging.Query;
import com.tom4sb.odigeek.domain.user.model.User;
import java.util.UUID;

public final class ViewUserById
    extends Query<User> {

  private final UUID userId;

  public ViewUserById(final UUID userId) {
    this.userId = userId;
  }

  public UUID getUserId() {
    return userId;
  }

}
