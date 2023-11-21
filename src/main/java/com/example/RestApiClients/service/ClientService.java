package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.ClientDTO;
import com.example.RestApiClients.models.Client;
import com.example.RestApiClients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getListClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(String clientId){
        return clientRepository.findById(clientId);
    }

    public void saveClient(ClientDTO clientDTO){
        Client client = new Client(clientDTO.getIdClient(), clientDTO.getClienteName(),
                clientDTO.getClientLastName(), clientDTO.getClientDirection(), clientDTO.getPhoneNumber());
        clientRepository.save(client);
    }

    public void deleteClient(String clientID){
        clientRepository.deleteById(clientID);
    }

}
