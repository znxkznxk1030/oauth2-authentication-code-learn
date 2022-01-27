//package ys.kim.authserver.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Map;
//
////@Controller
//public class LoginController {
//    private final String HTML_LOGIN = "login.html";
//    @GetMapping("/login")
//    public String login(@RequestParam Map<String,String> allParams, Model model) {
//        for (String key: allParams.keySet()) {
//            System.out.println("Key: " + key + ", value: " + allParams.get(key));
//        }
//        return HTML_LOGIN;
//    }
//}
