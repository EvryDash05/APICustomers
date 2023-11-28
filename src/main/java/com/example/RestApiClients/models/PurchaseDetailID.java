package com.example.RestApiClients.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class PurchaseDetailID implements Serializable {

    @Column(name = "idCompra")
    private Long purchaseId;

    @Column(name = "idProducto")
    private String productId;

    public PurchaseDetailID(Long purchaseId, String productId) {
        this.purchaseId = purchaseId;
        this.productId = productId;
    }

}
