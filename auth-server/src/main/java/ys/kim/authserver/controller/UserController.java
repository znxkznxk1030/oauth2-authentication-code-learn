package ys.kim.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping("/user/{username}")
    public String checkIfUserExist(@PathVariable("username") String username) {
        boolean isExist = jdbcUserDetailsManager.userExists(username);

        if (isExist) {
            return username + " is exist ";
        } else {
            return username + " is not exist";
        }
    }
}
