package com.springboot.crud_app.controller;

import com.springboot.crud_app.model.Customer;
import com.springboot.crud_app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}
