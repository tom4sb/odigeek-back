package com.tom4sb.odigeek.application.shared.messaging;

public interface QueryHandler<T extends Query<R>, R> {

  R ask(T query);

}
