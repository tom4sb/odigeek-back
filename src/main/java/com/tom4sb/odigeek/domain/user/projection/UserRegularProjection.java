package com.tom4sb.odigeek.domain.user.projection;

import com.tom4sb.odigeek.domain.user.model.User;

public class UserRegularProjection
    extends UserProjection {

  private String username;
  private String fullName;
  private String email;
  private String phone;
  private Integer age;
  private String homeCity;
  private String creditCard;
  private String bankAccount;
  private String role;

  public UserRegularProjection(final User user) {
    super(user.id().value());
    parse(user);
  }

  @Override
  protected void parse(final User user) {
    this.username = user.username().value();
    this.fullName = user.fullName().value();
    this.email = user.email().value();
    this.phone = user.phone().value();
    this.age = user.age().value();
    this.homeCity = user.homeCity().value();
    this.creditCard = user.bankDetails().creditCard();
    this.bankAccount = user.bankDetails().bankAccount();
    this.role = user.role().getValue().name();
  }

  public String getUsername() {
    return username;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public Integer getAge() {
    return age;
  }

  public String getHomeCity() {
    return homeCity;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public String getRole() {
    return role;
  }

}
