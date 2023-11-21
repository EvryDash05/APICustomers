package com.example.RestApiClients.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "ProductosComprados")
@NoArgsConstructor
@Data
public class PurchaseDetail implements Serializable {

    @EmbeddedId
    private PurchaseDetailID purchaseDetailId;

    @Basic
    @Column(name = "CantidadComprada")
    private int quantity;
    @Column(name = "MontoTotal")
    private BigDecimal totalAmnount;

    /*Relations*/
    @ManyToOne
    @JoinColumn(name = "IDProducto", referencedColumnName = "idProducto")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IDCompra", referencedColumnName = "IDCompra")
    private Purchase purchase;

    public PurchaseDetail(int quantity, BigDecimal totalAmnount, Product product, Purchase purchase) {
        this.quantity = quantity;
        this.totalAmnount = totalAmnount;
        this.product = product;
        this.purchase = purchase;
        this.purchaseDetailId = new PurchaseDetailID(purchase.getPurchaseId(), product.getProductId());
    }

}