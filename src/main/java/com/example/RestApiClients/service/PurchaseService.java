package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.repository.PurchaseDetailRepository;
import com.example.RestApiClients.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getListPurchase(){
        return purchaseRepository.findAll();
    }

    public Optional<?> getPurchaseById(Long purchaseId){
        return purchaseRepository.findById(purchaseId);
    }

    public void setPurchase(PurchaseDTO purchaseDTO){
        Purchase purchase = new Purchase(purchaseDTO.getPurchaseId(), purchaseDTO.getPurchaseStatus(),
                purchaseDTO.getPayment(), purchaseDTO.getCustomer());
        purchaseRepository.save(purchase);
    }

}
