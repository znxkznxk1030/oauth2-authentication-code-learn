package ys.kim.authserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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

    @Autowired
    DataSource dataSource;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests
//                .antMatchers("/user/**").hasRole("MANAGER")
                .anyRequest().authenticated()
        )
                .formLogin(ctx -> {
                    System.out.println(ctx.getClass());
                });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

//    @Bean
//    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager mgr = new JdbcUserDetailsManager();
//        mgr.setDataSource(dataSource);
//        return mgr;
//    }

    @Bean
    JdbcUserDetailsManager users() {
        return new JdbcUserDetailsManagerConfigurer<>()
                .dataSource(dataSource)
                .withDefaultSchema()  // org/springframework/security/core/userdetails/jdbc/users.ddl
                .passwordEncoder(passwordEncoder()) // BCryptPasswordEncoder
                .getUserDetailsService();
    }

}
