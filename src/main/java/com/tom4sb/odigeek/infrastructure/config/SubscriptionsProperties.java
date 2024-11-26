package com.tom4sb.odigeek.infrastructure.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "subscriptions")
public record SubscriptionsProperties(
    List<DefaultSubscriptionsProperties> defaults
) {

  public record DefaultSubscriptionsProperties(
      String id,
      String title,
      String supplier,
      List<String> categories,
      float priceAmount,
      String priceCurrency,
      String description,
      boolean active
  ) {

  }

}
