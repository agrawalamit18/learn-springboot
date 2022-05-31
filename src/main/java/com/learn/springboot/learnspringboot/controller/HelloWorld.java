package com.learn.springboot.learnspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Welcome to hello world!!!";
    }

    @GetMapping("/register")
    public String register() {
        return "Register Page";
    }

    @GetMapping("/login")
    public String login() {
        return "login Page";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout Page";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Authenticated. Welcome!";
    }
}
