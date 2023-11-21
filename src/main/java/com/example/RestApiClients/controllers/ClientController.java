package com.example.RestApiClients.controllers;

import com.example.RestApiClients.models.Client;
import com.example.RestApiClients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/listClients")
    public List<Client> getListClients(){
        return clientService.getListClients();
    }




}
