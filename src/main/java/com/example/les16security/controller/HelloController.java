package com.example.les16security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@AuthenticationPrincipal UserDetails ud) {
        if (ud != null) {
            return "Hello " + ud.getUsername() + "!";
        }
        else {
            return "Hello anynomous!";
        }
    }

    @GetMapping("/secret")
    public String tellSecret() {
        return "Very secret...";
    }
}
