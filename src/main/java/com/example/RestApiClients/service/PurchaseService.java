package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.DTO.PurchaseDetailDTO;
import com.example.RestApiClients.models.Customer;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.models.PurchaseDetail;
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
    @Autowired
    private CustomerService customerService;

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public void addPurhcaseDetail(List<PurchaseDetail> purchaseDetailList){

    }

    public Optional<Purchase> getPurchaseById(Long purchaseId){
        return purchaseRepository.findById(purchaseId);
    }

    public List<Purchase> getPurchaseListByIdCustomer(String customerId){
        Customer customer = customerService.getClientById(customerId).get();
        return customer.getPurchaseList();
    }


}
