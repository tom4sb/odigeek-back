package com.tom4sb.odigeek.domain.user.model;

import java.util.Optional;

public interface Users {

  void save(User user);

  Optional<User> findById(UserId id);

  Optional<User> findByUsername(UserName username);

}
