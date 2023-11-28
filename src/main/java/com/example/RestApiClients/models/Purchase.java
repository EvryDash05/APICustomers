package com.example.RestApiClients.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CompraCliente")
@NoArgsConstructor
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iDCompra")
    private Long purchaseId;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaPedido")
    private Date purchaseDate;

    @Column(name = "Estado")
    private String purchaseStatus;

    @Column(name = "MontoPago")
    private BigDecimal payment;

    /*RELATIONS*/
    @ManyToOne
    @JoinColumn(name = "iDCliente")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> purchaseDetailList;

    public Purchase(Date purchaseDate, String purchaseStatus, BigDecimal payment, Customer customer) {
        this.purchaseDate = purchaseDate;
        this.purchaseStatus = purchaseStatus;
        this.payment = payment;
        this.customer = customer;
        this.purchaseDetailList = new ArrayList<>();
    }

    public Purchase(String purchaseStatus, BigDecimal payment, Customer customer, List<PurchaseDetail>purchaseDetailList) {
        this.purchaseDate = new Date();
        this.purchaseStatus = purchaseStatus;
        this.payment = payment;
        this.customer = customer;
        this.purchaseDetailList = purchaseDetailList;
    }

}
