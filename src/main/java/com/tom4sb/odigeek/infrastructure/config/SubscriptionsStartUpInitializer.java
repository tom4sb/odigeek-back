package com.tom4sb.odigeek.infrastructure.config;

import com.tom4sb.odigeek.application.subscription.command.create.CreateSubscription;
import com.tom4sb.odigeek.application.subscription.command.create.CreateSubscriptionHandler;
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
  private final CreateSubscriptionHandler handler;
  private final SubscriptionsProperties subscriptionsProperties;

  public SubscriptionsStartUpInitializer(
      final CreateSubscriptionHandler handler,
      final SubscriptionsProperties subscriptionsProperties
  ) {
    this.handler = handler;
    this.subscriptionsProperties = subscriptionsProperties;
  }

  @Override
  public void run(final ApplicationArguments args) throws Exception {
    extractSuppliers(args).forEach(this::createSupplierSubscriptions);
  }

  private List<String> extractSuppliers(final ApplicationArguments args) {
    if (!args.containsOption(PROFILE_ARG)) {
      return Collections.emptyList();
    }

    return Arrays.asList(args.getOptionValues(PROFILE_ARG).getFirst().split(PROFILE_ARG_SEPARATOR));
  }

  private void createSupplierSubscriptions(final String supplier) {
    findSupplierDefaultProperties(supplier).forEach(this::createSubscription);
  }

  private List<DefaultSubscriptionsProperties> findSupplierDefaultProperties(final String supplier) {
    return subscriptionsProperties.defaults().stream()
        .filter(defaultConfig -> supplier.equals(defaultConfig.supplier()))
        .toList();
  }

  private void createSubscription(final DefaultSubscriptionsProperties defaultProperties) {
    final var command = new CreateSubscription(
        UUID.fromString(defaultProperties.id()),
        defaultProperties.title(),
        defaultProperties.categories(),
        (double) defaultProperties.price(),
        defaultProperties.currency(),
        defaultProperties.description()
    );

    handler.handle(command); // TODO use command bus
  }

}
