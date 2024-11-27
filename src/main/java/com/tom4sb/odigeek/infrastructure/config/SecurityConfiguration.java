package com.tom4sb.odigeek.infrastructure.config;

import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.BI_TEAM;
import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.FINANCE_TEAM;
import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.GEEK_SPECIALIST;
import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.SALES_TEAM;
import static com.tom4sb.odigeek.domain.user.model.UserRole.RoleValue.USER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(final HttpSecurity http)
      throws Exception {
    return http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            auth -> auth
                .requestMatchers("/odigeek/api/user").permitAll()
                .requestMatchers("/odigeek/api/user/**").hasAnyRole(
                    USER.name(),
                    BI_TEAM.name(),
                    FINANCE_TEAM.name(),
                    SALES_TEAM.name()
                )
                .requestMatchers("/odigeek/api/user/\\d+/subscriptions/**").hasRole(USER.name())
                .requestMatchers("/odigeek/api/offer").hasRole(GEEK_SPECIALIST.name())
                .requestMatchers("/odigeek/api/subscription").hasRole(GEEK_SPECIALIST.name())
                .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
