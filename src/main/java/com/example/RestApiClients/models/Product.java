package com.example.RestApiClients.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Producto")
@NoArgsConstructor
@Data
public class Product {

    @Id
    @Column(name = "idProducto")
    private String productId;

    @Basic
    @Column(name = "NombreProd")
    private String productName;

    @Column(name = "DescripcionProd")
    private String productDescription;

    @Column(name = "PrecioUnitario")
    private BigDecimal price;

    @Column(name = "Stock")
    private int quantity;

    /*RELATIONS*/
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<PurchaseDetail> purchaseDetailList;

    public Product(String productId, String productName, String productDescription, BigDecimal price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
    }


}
