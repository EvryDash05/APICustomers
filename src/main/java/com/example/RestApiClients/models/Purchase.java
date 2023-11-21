package com.example.RestApiClients.models;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ComprasCliente")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCompra")
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
    @JoinColumn(name = "IDCliente")
    private Client client;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> purchaseDetailList;

    public Purchase(Long purchaseId, String purchaseStatus, BigDecimal payment, Client client) {
        this.purchaseId = purchaseId;
        this.purchaseDate = new Date();
        this.purchaseStatus = purchaseStatus;
        this.payment = payment;
        this.client = client;
    }


}
