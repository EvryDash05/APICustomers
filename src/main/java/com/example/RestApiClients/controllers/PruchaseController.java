package com.example.RestApiClients.controllers;


import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.DTO.PurchaseDetailDTO;
import com.example.RestApiClients.models.Customer;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.service.CustomerService;
import com.example.RestApiClients.service.PurchaseDetailService;
import com.example.RestApiClients.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PruchaseController {

    @Autowired
    private PurchaseDetailService purchaseDetailService;
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private CustomerService customerService;
    private static Logger logger = LoggerFactory.getLogger(PruchaseController.class);

    @PostMapping("/purchaseProducts/{customerId}")
    public void createPurchase(@RequestBody List<PurchaseDetailDTO> listPurchaseDetailDTO, @PathVariable String customerId) {

        Customer customer = customerService.getClientById(customerId).get();

        PurchaseDTO purchaseDTO = new PurchaseDTO(listPurchaseDetailDTO, customer);

        Purchase purchase = new Purchase(purchaseDTO.getPurchaseDate(), purchaseDTO.getPurchaseStatus(),
                purchaseDTO.getPayment(), purchaseDTO.getCustomer());

        //The method 'createPurchase' return a purchase created
        Purchase createdPurchase = purchaseService.createPurchase(purchase);
        purchaseDetailService.getPurchaseDetailList(listPurchaseDetailDTO, createdPurchase);
    }

    @GetMapping("/getPurchase/{purchaseId}")
    public Purchase getPurchase(@PathVariable Long purchaseId) {
        return purchaseService.getPurchaseById(purchaseId).get();
    }

    @GetMapping("/getPruchaseByCustomer/{idCustomer}")
    public List<Purchase> getPruchase(@PathVariable String idCustomer) {
        return purchaseService.getPurchaseListByIdCustomer(idCustomer);
    }

    @GetMapping("/getPurchaseList")
    public List<Purchase> purchaseList(){
        return purchaseService.getPurchaseList();
    }

}
