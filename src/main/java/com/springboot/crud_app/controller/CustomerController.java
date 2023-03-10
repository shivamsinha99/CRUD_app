package com.springboot.crud_app.controller;

import com.springboot.crud_app.exception.ResourceNotFoundException;
import com.springboot.crud_app.model.Customer;
import com.springboot.crud_app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " Does not Exist."));
        return ResponseEntity.ok(customer);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customerDetails) {
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " Does not Exist."));
        updateCustomer.setFirstName(customerDetails.getFirstName());
        updateCustomer.setLastName(customerDetails.getLastName());
        updateCustomer.setEmailId(customerDetails.getEmailId());

        customerRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " Does not Exist."));

        customerRepository.delete(customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
