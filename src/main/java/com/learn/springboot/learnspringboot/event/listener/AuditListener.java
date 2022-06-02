package com.learn.springboot.learnspringboot.event.listener;

import com.learn.springboot.learnspringboot.entity.People;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class AuditListener {

    private static Log log = LogFactory.getLog(AuditListener.class);


    @PrePersist
    @PreUpdate
    @PostUpdate
    @PostPersist
    private void beforeAnyUpdate(People people) {
        log.info("Enter beforeAnyUpdate.");
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
