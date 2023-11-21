package com.example.RestApiClients.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PurchaseDetailID implements Serializable {

    @Column(name = "purchaseId")
    private Long purchaseId;

    @Column(name = "productID")
    private String productId;

    public PurchaseDetailID(Long purchaseId, String productId) {
        this.purchaseId = purchaseId;
        this.productId = productId;
    }
}