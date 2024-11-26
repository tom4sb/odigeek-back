package com.tom4sb.odigeek.infrastructure.domain.shared.messaging;

import com.tom4sb.odigeek.application.shared.messaging.Query;
import com.tom4sb.odigeek.application.shared.messaging.QueryBus;
import com.tom4sb.odigeek.application.shared.messaging.QueryHandler;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringQueryBus
    implements QueryBus {

  private static final Logger log = LoggerFactory.getLogger(SpringQueryBus.class);
  private final Map<Class, QueryHandler> handlers;

  public SpringQueryBus(final List<QueryHandler> queryHandlerImplementations) {
    this.handlers = new HashMap<>();
    queryHandlerImplementations.forEach(
        queryHandler -> {
          final var queryClass = getQueryClass(queryHandler);
          handlers.put(queryClass, queryHandler);
        }
    );
  }

  @Override
  public <R> R ask(final Query<R> query) {
    if (!handlers.containsKey(query.getClass())) {
      log.info("No handler for {}", query.getClass().getName());
      return null;
    }
    final QueryHandler<Query<R>, R> handler = handlers.get(query.getClass());
    return handler.ask(query);
  }

  private Class<?> getQueryClass(final QueryHandler handler) {
    final var queryInterface = ((ParameterizedType) handler.getClass()
        .getGenericInterfaces()[0])
        .getActualTypeArguments()[0];
    return getClass(queryInterface.getTypeName());
  }

  private Class<?> getClass(final String name) {
    try {
      return Class.forName(name);
    } catch (final Exception e) {
      return null;
    }
  }

}
