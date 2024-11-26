package com.tom4sb.odigeek.application.shared.messaging;

public interface QueryBus {

  <R> R ask(Query<R> query);

}
