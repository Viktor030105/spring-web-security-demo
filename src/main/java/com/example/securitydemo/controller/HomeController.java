package com.example.securitydemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello from Spring Security Demo " + request.getSession().getId();
    }
}
