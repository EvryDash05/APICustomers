package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.ProductDTO;
import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.DTO.PurchaseDetailDTO;
import com.example.RestApiClients.models.Product;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.models.PurchaseDetail;
import com.example.RestApiClients.repository.PurchaseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseDetailService {

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private ProductService productService;


    public List<PurchaseDetail> getPurchaseDetailList(List<PurchaseDetailDTO> purchaseDetailList, Purchase createdPurchase) {

        List<PurchaseDetail> listPurchaseDetail = new ArrayList<>();

        for(PurchaseDetailDTO purchaseDetailDTO : purchaseDetailList){

            Product product = productService.getProductById(purchaseDetailDTO.getProductId()).get();

            PurchaseDetail purchaseDetail = new PurchaseDetail(createdPurchase, product,
                    purchaseDetailDTO.getQuantity(), purchaseDetailDTO.getTotalAmnount());

            listPurchaseDetail.add(purchaseDetail);
            purchaseDetailRepository.save(purchaseDetail);
        }

        return listPurchaseDetail;
    }

}
