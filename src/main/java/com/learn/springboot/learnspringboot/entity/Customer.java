package com.learn.springboot.learnspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Customer {
    @PrimaryKey
    private int id;

    @Column("cust_name")
    private String custName;
}
