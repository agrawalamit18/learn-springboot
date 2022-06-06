package com.learn.springboot.learnspringboot.repository;


import com.learn.springboot.learnspringboot.entity.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CRepository extends CassandraRepository <Customer, Integer>
{

}