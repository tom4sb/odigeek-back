package com.tom4sb.odigeek.domain.subscription.model;

import java.util.List;

public interface Subscriptions {

  void save(Subscription subscription);

  List<Subscription> findAll();

}
