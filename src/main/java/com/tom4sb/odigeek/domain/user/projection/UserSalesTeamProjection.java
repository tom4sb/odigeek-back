package com.tom4sb.odigeek.domain.user.projection;

import com.tom4sb.odigeek.domain.user.model.User;

public class UserSalesTeamProjection
    extends UserProjection {

  private String name;
  private String email;
  private String phone;

  public UserSalesTeamProjection(final User user) {
    super(user.id().value());
    parse(user);
  }

  @Override
  protected void parse(final User user) {
    this.name = user.fullName().value();
    this.email = user.email().value();
    this.phone = user.phone().value();
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

}
