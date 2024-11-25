package com.tom4sb.odigeek.domain.shared.messaging;

public interface CommandBus {

  void dispatch(Command command);

}
