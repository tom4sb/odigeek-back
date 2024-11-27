package com.tom4sb.odigeek.domain.user.projection;

import com.tom4sb.odigeek.domain.user.model.User;
import java.util.UUID;

public abstract class UserProjection {

  private final UUID id;

  protected UserProjection(final UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  protected abstract void parse(User user);

}
