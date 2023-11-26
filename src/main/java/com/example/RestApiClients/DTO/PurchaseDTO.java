package com.example.RestApiClients.DTO;

import com.example.RestApiClients.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class PurchaseDTO {

    private Long purchaseId;
    private String purchaseStatus;
    private BigDecimal payment;
    private ArrayList<ProductDTO> productsList;
    private Customer customer;

    public PurchaseDTO(Long purchaseId, String purchaseStatus, ArrayList<ProductDTO> productsList) {
        this.purchaseId = purchaseId;
        this.purchaseStatus = purchaseStatus;
        this.payment = getPayment(productsList);
        this.productsList = productsList;
    }

    public PurchaseDTO(String purchaseStatus, ArrayList<ProductDTO> productsList) {
        this.purchaseStatus = purchaseStatus;
        this.payment = getPayment(productsList);
        this.productsList = productsList;
    }

    public BigDecimal getPayment(ArrayList<ProductDTO> productsList) {
        BigDecimal payment = productsList.stream().map(productDTO -> productDTO.getPrice())
                .filter(price -> price != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return payment;
    }

}
