package com.example.RestApiClients.service;

import com.example.RestApiClients.DTO.ProductDTO;
import com.example.RestApiClients.DTO.PurchaseDTO;
import com.example.RestApiClients.DTO.PurchaseDetailDTO;
import com.example.RestApiClients.models.Product;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.models.PurchaseDetail;
import com.example.RestApiClients.repository.PurchaseDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    private static final Logger logger = LoggerFactory.getLogger(PurchaseDetailService.class);


    public List<PurchaseDetail> getPurchaseDetailList(List<PurchaseDetailDTO> purchaseDetailList, Purchase createdPurchase) {

        List<PurchaseDetail> listPurchaseDetail = new ArrayList<>();
        BigDecimal totalPriceDetail;
        BigDecimal totalPricePurchase = BigDecimal.ZERO;

        for (PurchaseDetailDTO purchaseDetailDTO : purchaseDetailList) {

            Product product = productService.getProductById(purchaseDetailDTO.getProductId()).get();

            totalPriceDetail = (purchaseDetailDTO.getUnitPrice().multiply(BigDecimal.valueOf(purchaseDetailDTO.getQuantity())));
            totalPricePurchase = totalPricePurchase.add(totalPriceDetail);

            PurchaseDetail purchaseDetail = new PurchaseDetail(createdPurchase, product,
                    purchaseDetailDTO.getQuantity(), totalPriceDetail);

            productService.updateStock(product.getProductId(), Math.toIntExact(purchaseDetail.getQuantity()));

            listPurchaseDetail.add(purchaseDetail);
            purchaseDetailRepository.save(purchaseDetail);
        }

        logger.info("el precio total es :" + totalPricePurchase);
        purchaseService.updatePayment(createdPurchase, totalPricePurchase);
        return listPurchaseDetail;
    }

}
