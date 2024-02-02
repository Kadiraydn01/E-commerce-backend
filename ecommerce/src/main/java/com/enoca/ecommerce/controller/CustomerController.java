package com.enoca.ecommerce.controller;

import com.enoca.ecommerce.entity.Customer;
import com.enoca.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public List<Customer> getAllCustomers(){
        return customerService.listCustomers();
    }
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

}
