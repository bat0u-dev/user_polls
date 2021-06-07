package com.roganov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public String showMyLoginPage() {
        return "modern-login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}