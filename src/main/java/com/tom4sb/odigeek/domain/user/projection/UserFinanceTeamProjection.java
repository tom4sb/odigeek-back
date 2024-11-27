package com.tom4sb.odigeek.domain.user.projection;

import com.tom4sb.odigeek.domain.user.model.User;

public class UserFinanceTeamProjection
    extends UserProjection {

  private String creditCard;
  private String bankAccount;

  public UserFinanceTeamProjection(final User user) {
    super(user.id().value());
    parse(user);
  }

  @Override
  public void parse(final User user) {
    this.creditCard = user.bankDetails().creditCard();
    this.bankAccount = user.bankDetails().bankAccount();
  }

  public String getCreditCard() {
    return creditCard;
  }

  public String getBankAccount() {
    return bankAccount;
  }

}
