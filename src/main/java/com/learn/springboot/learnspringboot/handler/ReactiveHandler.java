package com.learn.springboot.learnspringboot.handler;

import com.learn.springboot.learnspringboot.dao.ReactiveExampleDao;
import com.learn.springboot.learnspringboot.entity.ReactiveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class ReactiveHandler {

    @Autowired
    private ReactiveExampleDao reactiveExampleDao;

    public Mono<ServerResponse> getWelcomeText(ServerRequest request) {
        System.out.println("Hi");
        return ServerResponse.ok().body(Mono.just("Welcome to handler test!!!")
                , String.class);
    }
}
