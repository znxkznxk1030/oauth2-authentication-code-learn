package ys.kim.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientCredentialsAuthenticationProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/cc")
    public String getUser() {
//        return jdbcUserDetailsManager.loadUserByUsername(username);
//
//        AuthenticationProvider authenticationProvider = new OAuth2ClientCredentialsAuthenticationProvider();
//
//        authenticationProvider.authenticate();
        return null;
    }
}
