package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.CustomerDTO;
import com.example.RestApiClients.models.Customer;
import com.example.RestApiClients.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository clientRepository;

    public List<Customer> getListClustomers(){
        return clientRepository.findAll();
    }

    public Optional<Customer> getClientById(String clientId){
        return clientRepository.findById(clientId);
    }

    public void saveClient(CustomerDTO clientDTO){
        Customer customer = new Customer(clientDTO.getCustomerId(), clientDTO.getCustomerName(),
                clientDTO.getCustomerLastName(), clientDTO.getCustomerDirection(), clientDTO.getPhoneNumber());
        clientRepository.save(customer);
    }

    public void deleteClient(String clientID){
        clientRepository.deleteById(clientID);
    }

}
