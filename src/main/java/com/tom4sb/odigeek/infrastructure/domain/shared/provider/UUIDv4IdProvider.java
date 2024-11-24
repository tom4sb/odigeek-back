package com.tom4sb.odigeek.infrastructure.domain.shared.provider;

import com.tom4sb.odigeek.domain.shared.provider.IdProvider;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UUIDv4IdProvider
    implements IdProvider<UUID> {

  @Override
  public UUID provide() {
    return UUID.randomUUID();
  }

}
