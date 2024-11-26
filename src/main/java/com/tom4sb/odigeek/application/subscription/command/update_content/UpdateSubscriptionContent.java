package com.tom4sb.odigeek.application.subscription.command.update_content;

import com.tom4sb.odigeek.application.shared.messaging.Command;

public final class UpdateSubscriptionContent
    extends Command {

  private final String title;

  public UpdateSubscriptionContent(final String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

}
