package com.example.RestApiClients.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "DetalleFactura")
@NoArgsConstructor
@Data
public class PurchaseDetail implements Serializable {


    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseDetailId;*/
    @EmbeddedId
    private PurchaseDetailID purchaseDetailId;

    @Basic
    @Column(name = "cantidadProducto")
    private Long quantity;
    @Column(name = "MontoProducto")
    private BigDecimal totalAmount;

    /*Relations*/
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IDCompra", referencedColumnName = "idCompra", insertable = false, updatable = false)
    @JsonBackReference
    private Purchase purchase;

    public PurchaseDetail(Purchase purchase, Product product, Long quantity, BigDecimal totalAmount) {
        this.purchase = purchase;
        this.product = product;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.purchaseDetailId = new PurchaseDetailID(purchase.getPurchaseId(), product.getProductId());
    }

}
