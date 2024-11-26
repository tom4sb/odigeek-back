package com.tom4sb.odigeek.infrastructure.config;

import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import com.tom4sb.odigeek.application.subscription.command.create.CreateSubscription;
import com.tom4sb.odigeek.application.subscription.command.update_status.UpdateSubscriptionStatus;
import com.tom4sb.odigeek.infrastructure.config.SubscriptionsProperties.DefaultSubscriptionsProperties;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionsStartUpInitializer
    implements ApplicationRunner {

  private static final String PROFILE_ARG = "profile";
  private static final String PROFILE_ARG_SEPARATOR = ",";
  private final CommandBus commandBus;
  private final SubscriptionsProperties subscriptionsProperties;

  public SubscriptionsStartUpInitializer(
      final CommandBus commandBus,
      final SubscriptionsProperties subscriptionsProperties
  ) {
    this.commandBus = commandBus;
    this.subscriptionsProperties = subscriptionsProperties;
  }

  @Override
  public void run(final ApplicationArguments args) {
    final var allProperties = subscriptionsProperties.defaults();
    createSubscriptions(allProperties);

    extractProfileSuppliers(args)
        .forEach(supplier -> activateSubscriptions(allProperties, supplier));
  }

  private void createSubscriptions(final List<DefaultSubscriptionsProperties> allProperties) {
    allProperties.forEach(this::createSubscription);
  }

  private void createSubscription(final DefaultSubscriptionsProperties subscriptionProperties) {
    final var command = new CreateSubscription(
        UUID.fromString(subscriptionProperties.id()),
        subscriptionProperties.title(),
        subscriptionProperties.categories(),
        (double) subscriptionProperties.priceAmount(),
        subscriptionProperties.priceCurrency(),
        subscriptionProperties.description(),
        subscriptionProperties.active()
    );

    commandBus.dispatch(command);
  }

  private List<String> extractProfileSuppliers(final ApplicationArguments args) {
    if (!args.containsOption(PROFILE_ARG)) {
      return Collections.emptyList();
    }

    return Arrays.asList(args.getOptionValues(PROFILE_ARG).getFirst().split(PROFILE_ARG_SEPARATOR));
  }

  private void activateSubscriptions(
      final List<DefaultSubscriptionsProperties> allProperties,
      final String supplier
  ) {
    findSuppliersubscriptionsProperties(allProperties, supplier).forEach(this::activateSubscription);
  }

  private List<DefaultSubscriptionsProperties> findSuppliersubscriptionsProperties(
      final List<DefaultSubscriptionsProperties> allProperties,
      final String supplier
  ) {
    return allProperties.stream()
        .filter(subscriptionProperties -> supplier.equals(subscriptionProperties.supplier()))
        .toList();
  }

  private void activateSubscription(final DefaultSubscriptionsProperties subscriptionProperties) {
    final var command = new UpdateSubscriptionStatus(
        UUID.fromString(subscriptionProperties.id()),
        Boolean.TRUE
    );

    commandBus.dispatch(command);
  }

}
