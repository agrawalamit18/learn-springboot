package com.learn.springboot.learnspringboot.configuration;

import com.learn.springboot.learnspringboot.handler.ReactiveHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ReactiveConfiguration {

    @Autowired
    private ReactiveHandler reactiveHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/getWelcomeText", reactiveHandler::getWelcomeText)
                .build();
    }
}
