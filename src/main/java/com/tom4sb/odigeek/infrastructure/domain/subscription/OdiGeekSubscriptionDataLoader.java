package com.tom4sb.odigeek.infrastructure.domain.subscription;

import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierName.DRAGON_BALL;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierName.STAR_WARS;

import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionDataLoader;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierName;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class OdiGeekSubscriptionDataLoader
    implements SubscriptionDataLoader {

  private static final Map<SupplierName, SupplierDataLoader> supplierDataLoaders = new HashMap<>();

  public OdiGeekSubscriptionDataLoader(
      final SupplierDataLoader dragonBallSupplierDataLoader,
      final SupplierDataLoader starWarsSupplierDataLoader
  ) {
    supplierDataLoaders.put(DRAGON_BALL, dragonBallSupplierDataLoader);
    supplierDataLoaders.put(STAR_WARS, starWarsSupplierDataLoader);
  }

  @Override
  public SubscriptionContent load(final SubscriptionTitle title) {
    final var supplierDataLoader = supplierDataLoaders.get(title.getValue().getSupplierName());

    return supplierDataLoader.load(title);
  }

}
