package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.ProductDTO;
import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.DTO.PurchaseDetailDTO;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.models.PurchaseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseDetailService {

    @Autowired
    private PurchaseService purchaseService;

    public List<PurchaseDetail> generatePurchaseDetailList(PurchaseDTO purchaseDTO) {

        List<PurchaseDetail> detailList = new ArrayList<>();
        ArrayList<ProductDTO> listProducts = purchaseDTO.getProductsList();
        int i = 0;

        while(i < listProducts.size()) {



        }


    }



}
