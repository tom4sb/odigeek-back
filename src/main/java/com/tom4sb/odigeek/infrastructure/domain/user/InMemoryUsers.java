package com.tom4sb.odigeek.infrastructure.domain.user;

import com.tom4sb.odigeek.domain.user.model.User;
import com.tom4sb.odigeek.domain.user.model.UserId;
import com.tom4sb.odigeek.domain.user.model.UserName;
import com.tom4sb.odigeek.domain.user.model.Users;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUsers
    implements Users {

  private static final Logger log = LoggerFactory.getLogger(InMemoryUsers.class);
  private static final Map<UserId, User> users = new HashMap<>();

  @Override
  public void save(final User user) {
    users.put(user.id(), user);

    log.info("User with ID {}, username {} and role {} saved!",
        user.id().value(),
        user.username().value(),
        user.role().getValue()
    );
  }

  @Override
  public Optional<User> findById(final UserId id) {
    return Optional.ofNullable(users.get(id));
  }

  @Override
  public Optional<User> findByUsername(final UserName username) {
    return users.values().stream()
        .filter(user -> user.username().equals(username))
        .findFirst();
  }

}
