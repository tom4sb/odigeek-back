package com.tom4sb.odigeek.domain.shared.messaging;

public interface CommandHandler<T extends Command> {

  void handle(T command);

}
