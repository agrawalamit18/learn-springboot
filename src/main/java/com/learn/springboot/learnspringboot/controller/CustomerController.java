package com.learn.springboot.learnspringboot.controller;

import com.learn.springboot.learnspringboot.entity.Customer;
import com.learn.springboot.learnspringboot.repository.CRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
    public CRepository repo;

    @GetMapping("/addCustomer")
    public Customer addCust(@RequestParam("id") int id, @RequestParam("name") String name) {
        Customer cust = new Customer();
        cust.setCustName(name);
        cust.setId(id);
        cust = repo.save(cust);
        return cust;
    }
}