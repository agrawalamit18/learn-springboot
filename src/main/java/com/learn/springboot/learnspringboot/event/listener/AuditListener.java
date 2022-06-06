package com.learn.springboot.learnspringboot.event.listener;

import com.learn.springboot.learnspringboot.entity.People;
import com.learn.springboot.learnspringboot.event.kafka.producer.Producer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

public class AuditListener {

    private static Log log = LogFactory.getLog(AuditListener.class);

    @Autowired
    public Producer producer;

    @PostUpdate
    @PostPersist
    private void beforeAnyUpdate(People people) {
        producer.produceMessage(people);
    }

    @PostRemove
    private void deleteRecord(People people){
        log.info("Enter deleteRecord - "+ people.getId());
    }

    @PostLoad
    private void afterLoad(People people) {
        log.info("Data loaded successfully.");
    }
}
