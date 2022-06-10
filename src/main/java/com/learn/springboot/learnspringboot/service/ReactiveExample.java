package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.dao.ReactiveExampleDao;
import com.learn.springboot.learnspringboot.entity.ReactiveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReactiveExample {

    @Autowired
    private ReactiveExampleDao custDao;

    public Flux<ReactiveEntity> getAll () {
        return custDao.getAll();
    }
}
