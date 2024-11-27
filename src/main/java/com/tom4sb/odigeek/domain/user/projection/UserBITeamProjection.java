package com.tom4sb.odigeek.domain.user.projection;

import com.tom4sb.odigeek.domain.user.model.User;

public class UserBITeamProjection
    extends UserProjection {

  private Integer age;
  private String homeCity;

  public UserBITeamProjection(final User user) {
    super(user.id().value());
    parse(user);
  }

  @Override
  public void parse(final User user) {
    this.age = user.age().value();
    this.homeCity = user.homeCity().value();
  }

  public Integer getAge() {
    return age;
  }

  public String getHomeCity() {
    return homeCity;
  }

}
