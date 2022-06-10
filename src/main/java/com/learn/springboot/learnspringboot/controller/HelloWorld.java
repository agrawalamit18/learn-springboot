package com.learn.springboot.learnspringboot.controller;

import com.learn.springboot.learnspringboot.annotation.TestAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@TestAnnotation (name="HelloWorld")
public class HelloWorld {

    @GetMapping("/hello")
    public String helloWorld() {
        Mono<String> str =  Mono.just("Hello").log();
        str.subscribe(System.out::println);


        Flux<String> data = Flux.just("a","b").log();
        data.subscribe(System.out::println);
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
