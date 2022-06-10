package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.ReactiveEntity;
import com.learn.springboot.learnspringboot.service.ReactiveExample;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class ReactiveExampleDao {

    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Flux<ReactiveEntity> getAll() {
        return Flux.range(0,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing element - " + i))
                .map(i -> new ReactiveEntity("1", "Amit -" +i));
    }
}
