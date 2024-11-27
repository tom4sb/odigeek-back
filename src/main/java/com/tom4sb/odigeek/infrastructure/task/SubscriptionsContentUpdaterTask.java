package com.tom4sb.odigeek.infrastructure.task;

import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import com.tom4sb.odigeek.application.subscription.command.update_content.UpdateSubscriptionContent;
import com.tom4sb.odigeek.infrastructure.config.SubscriptionsProperties;
import com.tom4sb.odigeek.infrastructure.config.SubscriptionsProperties.DefaultSubscriptionsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionsContentUpdaterTask {

  private static final Logger log = LoggerFactory.getLogger(SubscriptionsContentUpdaterTask.class);
  private final CommandBus commandBus;
  private final SubscriptionsProperties subscriptionsProperties;

  public SubscriptionsContentUpdaterTask(
      final CommandBus commandBus,
      final SubscriptionsProperties subscriptionsProperties
  ) {
    this.commandBus = commandBus;
    this.subscriptionsProperties = subscriptionsProperties;
  }

  //@Scheduled(cron = "*/5 * * * * *") // Every 5 seconds
  @Scheduled(cron = "0 0 1 * * MON-FRI") // Every weekday, from Monday to Friday, at 01:00 am
  public void run() {
    log.info("********** Starting task to update subscriptions content... **********");

    subscriptionsProperties.defaults().stream()
        .map(DefaultSubscriptionsProperties::title)
        .forEach(this::updateSubscriptionContent);

    log.info("********** Task to update subscriptions content finished!!! **********");
  }

  private void updateSubscriptionContent(final String title) {
    log.info("Updating {} subscription content...", title);

    commandBus.dispatch(new UpdateSubscriptionContent(title));

    log.info("{} subscription content updated!", title);
  }

}
