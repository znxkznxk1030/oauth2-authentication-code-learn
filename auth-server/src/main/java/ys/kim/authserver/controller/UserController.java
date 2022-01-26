package ys.kim.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @PostMapping("/create")
    public void createUser(@RequestBody UserDetails userDetails) {
        jdbcUserDetailsManager.createUser(userDetails);
    }

    @GetMapping("/detail/{username}")
    public UserDetails getUser(@PathVariable("username") String username) {
        return jdbcUserDetailsManager.loadUserByUsername(username);
    }

    @GetMapping("/{username}")
    public String checkIfUserExist(@PathVariable("username") String username) {
        boolean isExist = jdbcUserDetailsManager.userExists(username);

        if (isExist) {
            return username + " 존재한다 ";
        } else {
            return username + " 존재하지 않는다 ";
        }
    }
}
