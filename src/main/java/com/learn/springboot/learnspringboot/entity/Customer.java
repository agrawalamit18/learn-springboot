package com.learn.springboot.learnspringboot.entity;

import com.learn.springboot.learnspringboot.event.listener.AuditListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.EntityListeners;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@EntityListeners(AuditListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Customer {

    private static Log log = LogFactory.getLog(Customer.class);


    @PrimaryKey
    private int id;

    @Column("cust_name")
    private String custName;

    @PostPersist
    @PostUpdate
    public void generateEvent() {
        log.info("Calling generateEvent");
    }
}
