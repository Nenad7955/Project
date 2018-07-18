package com.javasampleapproach.angularjs.controller;

import java.util.ArrayList;
import java.util.List;

import com.javasampleapproach.angularjs.model.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.angularjs.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    List<Customer> cust = new ArrayList<Customer>();

    RestWebController(){
        cust.add(new Customer("Nenad",19, new Address("Leninova 18", "2000")));
    }



    @GetMapping(value = "/all")
    public List<Customer> getResource() {
        return cust;
    }

    @GetMapping(value = "/test")
    public String getRandom() {
        return "I'M ALIVEEEE";
    }



    @PostMapping(value = "/save")
    public String postCustomer(@RequestBody List<Customer> customers) {
        cust.addAll(customers);
        return "Post Successfully!";
    }
}