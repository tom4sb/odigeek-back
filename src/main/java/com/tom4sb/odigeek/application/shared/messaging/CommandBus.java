package com.tom4sb.odigeek.application.shared.messaging;

public interface CommandBus {

  void dispatch(Command command);

}
