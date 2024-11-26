package com.tom4sb.odigeek.application.shared.messaging;

public interface CommandHandler<T extends Command> {

  void handle(T command);

}
