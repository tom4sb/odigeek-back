package com.tom4sb.odigeek.application.user.command.create;

import com.tom4sb.odigeek.domain.shared.messaging.Command;

public final class CreateUser
    extends Command {

  private final String username;
  private final String password;
  private final String fullName;
  private final String email;
  private final String phone;
  private final Integer age;
  private final String homeCity;
  private final String creditCard;
  private final String bankAccount;
  private final String role;

  public CreateUser(
      final String username,
      final String password,
      final String fullName,
      final String email,
      final String phone,
      final Integer age,
      final String homeCity,
      final String creditCard,
      final String bankAccount,
      final String role
  ) {
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
    this.age = age;
    this.homeCity = homeCity;
    this.creditCard = creditCard;
    this.bankAccount = bankAccount;
    this.role = role;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
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
