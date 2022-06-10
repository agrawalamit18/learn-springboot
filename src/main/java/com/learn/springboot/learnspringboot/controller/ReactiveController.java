package com.learn.springboot.learnspringboot.controller;

import com.learn.springboot.learnspringboot.entity.ReactiveEntity;
import com.learn.springboot.learnspringboot.service.ReactiveExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ReactiveController {

    @Autowired
    private ReactiveExample reactiveExample;

    @GetMapping("/getAllWithoutStream")
    public Flux<ReactiveEntity> getAllWithoutStream () {
        return reactiveExample.getAll();
    }

    @GetMapping(value="/getAllWithStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ReactiveEntity> getAllWithStream () {
        return reactiveExample.getAll();
    }
}
