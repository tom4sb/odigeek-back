package com.tom4sb.odigeek.infrastructure.security;

import com.tom4sb.odigeek.domain.user.model.UserName;
import com.tom4sb.odigeek.domain.user.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
    implements UserDetailsService {

  private final PasswordEncoder passwordEncoder;
  private final Users users;

  public CustomUserDetailsService(
      final PasswordEncoder passwordEncoder,
      final Users users
  ) {
    this.passwordEncoder = passwordEncoder;
    this.users = users;
  }

  @Override
  public UserDetails loadUserByUsername(final String username)
      throws UsernameNotFoundException {
    final var user = users.findByUsername(new UserName(username));
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User " + username + "not found");
    }
    return org.springframework.security.core.userdetails.User.builder()
        .username(user.get().username().value())
        .password(passwordEncoder.encode(user.get().password().value()))
        .roles(user.get().role().getValue().name())
        .build();
  }

}
