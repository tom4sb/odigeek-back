package com.tom4sb.odigeek.application.user.command.create;

import com.tom4sb.odigeek.domain.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.shared.provider.IdProvider;
import com.tom4sb.odigeek.domain.user.model.User;
import com.tom4sb.odigeek.domain.user.model.UserAge;
import com.tom4sb.odigeek.domain.user.model.UserBankDetails;
import com.tom4sb.odigeek.domain.user.model.UserEmail;
import com.tom4sb.odigeek.domain.user.model.UserFullName;
import com.tom4sb.odigeek.domain.user.model.UserHomeCity;
import com.tom4sb.odigeek.domain.user.model.UserId;
import com.tom4sb.odigeek.domain.user.model.UserName;
import com.tom4sb.odigeek.domain.user.model.UserPassword;
import com.tom4sb.odigeek.domain.user.model.UserPhone;
import com.tom4sb.odigeek.domain.user.model.UserRole;
import com.tom4sb.odigeek.domain.user.model.Users;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public final class CreateUserHandler
    implements CommandHandler<CreateUser> {

  private final IdProvider<UUID> idProvider;
  private final Users users;

  public CreateUserHandler(
      final IdProvider<UUID> idProvider,
      final Users users
  ) {
    this.idProvider = idProvider;
    this.users = users;
  }

  @Override
  public void handle(final CreateUser command) {
    final var id = new UserId(idProvider.provide());
    final var username = new UserName(command.getUsername());
    final var password = new UserPassword(command.getPassword());
    final var fullName = new UserFullName(command.getFullName());
    final var email = new UserEmail(command.getEmail());
    final var phone = new UserPhone(command.getPhone());
    final var age = new UserAge(command.getAge());
    final var homeCity = new UserHomeCity(command.getHomeCity());
    final var bankDetails = new UserBankDetails(command.getCreditCard(), command.getBankAccount());
    final var role = new UserRole(command.getRole());

    final var user = new User(
        id,
        username,
        password,
        fullName,
        email,
        phone,
        age,
        homeCity,
        bankDetails,
        role
    );

    users.save(user);
  }

}
