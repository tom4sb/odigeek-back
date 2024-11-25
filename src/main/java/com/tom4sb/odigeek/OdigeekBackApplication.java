package com.tom4sb.odigeek;

import com.tom4sb.odigeek.infrastructure.config.SubscriptionsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(SubscriptionsProperties.class)
@SpringBootApplication
public class OdigeekBackApplication {

  public static void main(final String[] args) {
    SpringApplication.run(OdigeekBackApplication.class, args);
  }

}
