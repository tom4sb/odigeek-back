package com.tom4sb.odigeek.application.user.query.view_by_id;

import com.tom4sb.odigeek.application.shared.messaging.QueryHandler;
import com.tom4sb.odigeek.domain.user.model.User;
import com.tom4sb.odigeek.domain.user.model.UserId;
import com.tom4sb.odigeek.domain.user.model.Users;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public final class ViewUserByIdHandler
    implements QueryHandler<ViewUserById, User> {

  private final Users users;

  public ViewUserByIdHandler(final Users users) {
    this.users = users;
  }

  @Override
  public User ask(final ViewUserById query) {
    return users.findById(new UserId(query.getUserId()))
        .orElseThrow(NoSuchElementException::new);
  }

}
