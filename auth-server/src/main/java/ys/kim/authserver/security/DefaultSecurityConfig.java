package ys.kim.authserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@EnableWebSecurity
public class DefaultSecurityConfig {

  final DataSource dataSource;

  public DefaultSecurityConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(
            authorizeRequests -> {
              authorizeRequests.anyRequest().authenticated();
            })
        .csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .formLogin(
            login -> {
              login.loginPage("http://localhost:3000");
              login.loginProcessingUrl("/login-process");
            });

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(10);
  }

  @Bean
  JdbcUserDetailsManager users() {
    return new JdbcUserDetailsManagerConfigurer<>()
        .dataSource(dataSource) // jdbc:postgresql://localhost:5432/postgres
        .withDefaultSchema() // org/springframework/security/core/userdetails/jdbc/users.ddl
        .passwordEncoder(passwordEncoder()) // BCryptPasswordEncoder
        .getUserDetailsService();
  }
}
