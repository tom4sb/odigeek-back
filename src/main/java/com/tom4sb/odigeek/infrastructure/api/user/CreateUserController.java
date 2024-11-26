package com.tom4sb.odigeek.infrastructure.api.user;

import com.tom4sb.odigeek.application.shared.messaging.CommandBus;
import com.tom4sb.odigeek.application.user.command.create.CreateUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/odigeek/api/user")
public class CreateUserController {

  private final CommandBus commandBus;

  public CreateUserController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED) // TODO: Must return 403 if user already exists
  public void action(@RequestBody final CreateUserRequest request) {
    final var command = new CreateUser(
        request.username,
        request.password,
        request.fullName,
        request.email,
        request.phone,
        request.age,
        request.homeCity,
        request.creditCard,
        request.bankAccount,
        request.role
    );

    commandBus.dispatch(command);
  }

  static final class CreateUserRequest {
    public String username;
    public String password;
    public String fullName;
    public String email;
    public String phone;
    public Integer age;
    public String homeCity;
    public String creditCard;
    public String bankAccount;
    public String role;
  }

}
