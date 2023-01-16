package com.springboot.crud_app;

import com.springboot.crud_app.model.Customer;
import com.springboot.crud_app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Shivam");
        customer.setLastName("Sinha");
        customer.setEmailId("shivamsinha@airasia.com");
        customerRepository.save(customer);

        Customer customer_1 = new Customer();
        customer_1.setFirstName("Nilay");
        customer_1.setLastName("Kumar");
        customer_1.setEmailId("nilaynilay@airasia.com");
        customerRepository.save(customer_1);
    }
}
