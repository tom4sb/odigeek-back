package com.tom4sb.odigeek.infrastructure.api.user;

import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.BI_TEAM;
import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.FINANCE_TEAM;
import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.SALES_TEAM;

import com.tom4sb.odigeek.application.shared.messaging.QueryBus;
import com.tom4sb.odigeek.application.user.query.view_by_id.ViewUserById;
import com.tom4sb.odigeek.domain.user.model.User;
import com.tom4sb.odigeek.domain.user.model.UserRole;
import com.tom4sb.odigeek.domain.user.projection.UserBITeamProjection;
import com.tom4sb.odigeek.domain.user.projection.UserFinanceTeamProjection;
import com.tom4sb.odigeek.domain.user.projection.UserProjection;
import com.tom4sb.odigeek.domain.user.projection.UserRegularProjection;
import com.tom4sb.odigeek.domain.user.projection.UserSalesTeamProjection;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/odigeek/api/user")
@RestController
public class ViewUserByIdController {

  private final QueryBus queryBus;

  public ViewUserByIdController(final QueryBus queryBus) {
    this.queryBus = queryBus;
  }

  @GetMapping("/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public UserProjection action(@PathVariable final UUID userId) {
    final var query = new ViewUserById(userId);

    return parse(queryBus.ask(query), extractRoleFromSecurity());
  }

  private UserProjection parse(final User user, final UserRole role) {
    if (BI_TEAM == role.getValue()) {
      return new UserBITeamProjection(user);
    }
    if (FINANCE_TEAM == role.getValue()) {
      return new UserFinanceTeamProjection(user);
    }
    if (SALES_TEAM == role.getValue()) {
      return new UserSalesTeamProjection(user);
    }
    return new UserRegularProjection(user);
  }

  private UserRole extractRoleFromSecurity() {
    final var userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return new UserRole(
        userDetails.getAuthorities().stream()
            .findFirst()
            .map(value -> value.toString().replace("ROLE_", ""))
            .orElseThrow()
    );
  }

}
