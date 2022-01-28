package ys.kim.authserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class LoginController {
    private final String LOGIN_JSP = "login";

    @GetMapping("/login")
    public ModelAndView login(@RequestParam Map<String,String> allParams, Model model) {
        return new ModelAndView(LOGIN_JSP);
    }
}
