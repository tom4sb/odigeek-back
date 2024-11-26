package com.tom4sb.odigeek.domain.offer.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class OfferPeriodTest {

  @Test
  void should_fail_with_null_start_and_end() {
    assertThatThrownBy(() -> new OfferPeriod(null, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_start() {
    assertThatThrownBy(() -> new OfferPeriod(null, Instant.now()))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_null_end() {
    assertThatThrownBy(() -> new OfferPeriod(Instant.now(), null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void should_fail_with_end_before_start() {
    final var now = Instant.now();
    final var yesterday = now.minus(1, ChronoUnit.DAYS);
    assertThatThrownBy(() -> new OfferPeriod(now, yesterday))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
