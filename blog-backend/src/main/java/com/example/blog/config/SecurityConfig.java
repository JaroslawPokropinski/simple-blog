package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
    return http.authorizeExchange().pathMatchers(HttpMethod.GET, "/post").permitAll()
        .pathMatchers(HttpMethod.OPTIONS, "/post").permitAll().pathMatchers("/h2-console/**").permitAll().anyExchange()
        .authenticated().and().httpBasic().and().csrf().disable().build();
  }

  @Bean
  public MapReactiveUserDetailsService userDetailsService() {
    UserDetails user = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
    return new MapReactiveUserDetailsService(user);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}