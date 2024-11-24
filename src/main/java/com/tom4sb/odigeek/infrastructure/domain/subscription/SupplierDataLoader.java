package com.tom4sb.odigeek.infrastructure.domain.subscription;

import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;

public interface SupplierDataLoader {

  SubscriptionContent load(SubscriptionTitle title);

}
