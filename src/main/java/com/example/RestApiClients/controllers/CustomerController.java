package com.example.RestApiClients.controllers;

import com.example.RestApiClients.DTO.CustomerDTO;
import com.example.RestApiClients.models.Customer;
import com.example.RestApiClients.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/listClients")
    public List<Customer> getListClients(){
        return customerService.getListClustomers();
    }

    @PostMapping("/registerCustomer")
    public void registerEmployee(@RequestBody CustomerDTO customerDTO){
        customerService.saveClient(customerDTO);
    }




}
