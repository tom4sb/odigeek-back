package com.tom4sb.odigeek.infrastructure.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscriptionsPropertiesTest {

  @Autowired
  SubscriptionsProperties subscriptions;

  @Test
  void should_get_all() {
    final var defaults = subscriptions.defaults();

    assertEquals(4, defaults.size());
  }

  @Test
  void should_get_dragon_ball() {
    final var expectedSupplier = "dragon-ball";
    final var dragonBallDefaults = subscriptions.defaults().stream()
        .filter(defaultConfig -> expectedSupplier.equals(defaultConfig.supplier()))
        .toList();

    assertEquals(2, dragonBallDefaults.size());
  }

}
