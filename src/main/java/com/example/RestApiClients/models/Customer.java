package com.example.RestApiClients.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clientes")
@Data
public class Customer {

    @Id
    @Column(name = "idCliente ")
    private String customerId;

    @Basic
    @Column(name = "NomCliente")
    private String customerName;

    @Column(name = "ApeCliente")
    private String customerLastName;

    @Column(name = "Direccion")
    private String customerDirection;

    @Column(name = "TelCliente")
    private String phoneNumber;

    /*RELATIONS*/
    @OneToMany(mappedBy = "client")
    private List<Purchase> purchaseList;

    public Customer() {
        this.purchaseList = purchaseList;
    }

    public Customer(String customerId, String customerName, String customerLastName, String customerDirection, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerDirection = customerDirection;
        this.phoneNumber = phoneNumber;
        this.purchaseList = new ArrayList<Purchase>();
    }

    public void addPurchase(Purchase purchase){
        this.purchaseList.add(purchase);
    }



}
