package ys.kim.resourceserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {
  
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.mvcMatcher("/cello/**")
      .authorizeRequests()
      .mvcMatchers("/cello/**")
      .access("hasAuthority('SCOPE_cello.read')")
      .and()
      .oauth2ResourceServer();
      
    return http.build();
  }
}
