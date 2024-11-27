package com.tom4sb.odigeek.infrastructure.task;

import static com.tom4sb.odigeek.domain.offer.model.OfferScope.OfferScopeValue.CATALOG;
import static com.tom4sb.odigeek.domain.offer.model.OfferScope.OfferScopeValue.CATEGORY;
import static com.tom4sb.odigeek.domain.offer.model.OfferScope.OfferScopeValue.TITLE;

import com.tom4sb.odigeek.domain.offer.model.Offer;
import com.tom4sb.odigeek.domain.offer.model.OfferScope.OfferScopeValue;
import com.tom4sb.odigeek.domain.offer.model.Offers;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import com.tom4sb.odigeek.infrastructure.task.offer_applier.SubscriptionOfferApplier;
import com.tom4sb.odigeek.infrastructure.task.offer_applier.SubscriptionOfferByCategoryApplier;
import com.tom4sb.odigeek.infrastructure.task.offer_applier.SubscriptionOfferByTitleApplier;
import com.tom4sb.odigeek.infrastructure.task.offer_applier.SubscriptionOfferFullCatalogApplier;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OfferApplierTask {

  private static final Logger log = LoggerFactory.getLogger(OfferApplierTask.class);
  private final Map<OfferScopeValue, SubscriptionOfferApplier> subscriptionOfferAppliers;
  private final Offers offers;
  private final Subscriptions subscriptions;

  public OfferApplierTask(
      final Offers offers,
      final Subscriptions subscriptions
  ) {
    subscriptionOfferAppliers = Map.of(
        CATEGORY, new SubscriptionOfferByCategoryApplier(),
        CATALOG, new SubscriptionOfferFullCatalogApplier(),
        TITLE, new SubscriptionOfferByTitleApplier()
    );

    this.offers = offers;
    this.subscriptions = subscriptions;
  }

  //@Scheduled(cron = "*/15 * * * * *") // Every 15 seconds
  @Scheduled(cron = "0 5 0 * * *") // Every day at 00:05 am
  public void run() {
    log.info("********** Starting task to apply offers... **********");

    final var offersStartingTodayByScope = offers.findByPeriodStart(Instant.now()).stream()
        .collect(Collectors.groupingBy(Offer::scope));

    offersStartingTodayByScope.keySet().forEach(
        offerScope ->
            subscriptionOfferAppliers.get(offerScope.getValue()).apply(
                offersStartingTodayByScope.get(offerScope),
                subscriptions.getAll()
            )
    );

    log.info("********** Task to apply offers finished!!! **********");
  }

}
