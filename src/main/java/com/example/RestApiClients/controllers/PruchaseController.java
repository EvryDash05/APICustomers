package com.example.RestApiClients.controllers;


import com.example.RestApiClients.DTO.CustomerDTO;
import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.models.Product;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class PruchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchaseProducts")
    public void purchaseProducts(@RequestBody PurchaseDTO purchaseDTO, @RequestBody CustomerDTO customerDTO){
        purchaseService.setPurchase(purchaseDTO, customerDTO);
    }



}
