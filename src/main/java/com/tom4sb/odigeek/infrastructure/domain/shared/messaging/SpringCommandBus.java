package com.tom4sb.odigeek.infrastructure.domain.shared.messaging;

import com.tom4sb.odigeek.domain.shared.messaging.Command;
import com.tom4sb.odigeek.domain.shared.messaging.CommandBus;
import com.tom4sb.odigeek.domain.shared.messaging.CommandHandler;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandBus
    implements CommandBus {

  private static final Logger log = LoggerFactory.getLogger(SpringCommandBus.class);
  private final Map<Class, CommandHandler> handlers;

  public SpringCommandBus(final List<CommandHandler> commandHandlerImplementations) {
    this.handlers = new HashMap<>();
    commandHandlerImplementations.forEach(
        commandHandler -> {
          final var commandClass = getCommandClass(commandHandler);
          handlers.put(commandClass, commandHandler);
        }
    );
  }

  @Override
  public void dispatch(final Command command) {
    if (!handlers.containsKey(command.getClass())) {
      log.info("No handler for {}", command.getClass().getName());
      return;
    }
    handlers.get(command.getClass()).handle(command);
  }

  private Class<?> getCommandClass(final CommandHandler handler) {
    final var commandInterface = ((ParameterizedType) handler.getClass()
        .getGenericInterfaces()[0])
        .getActualTypeArguments()[0];
    return getClass(commandInterface.getTypeName());
  }

  private Class<?> getClass(final String name) {
    try {
      return Class.forName(name);
    } catch (final Exception e) {
      return null;
    }
  }

}
