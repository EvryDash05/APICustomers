package com.example.RestApiClients.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clientes")
@Data
public class Client {

    @Id
    @Column(name = "idCliente ")
    private String idClient;

    @Basic
    @Column(name = "NomCliente")
    private String clienteName;

    @Column(name = "ApeCliente")
    private String clientLastName;

    @Column(name = "Direccion")
    private String clientDirection;

    @Column(name = "TelCliente")
    private String phoneNumber;

    /*RELATIONS*/
    @OneToMany(mappedBy = "client")
    private List<Purchase> purchaseList;

    public Client() {
        this.purchaseList = purchaseList;
    }

    public Client(String idClient, String clienteName, String clientLastName, String clientDirection, String phoneNumber) {
        this.idClient = idClient;
        this.clienteName = clienteName;
        this.clientLastName = clientLastName;
        this.clientDirection = clientDirection;
        this.phoneNumber = phoneNumber;
        this.purchaseList = new ArrayList<Purchase>();
    }

    public void addPurchase(Purchase purchase){
        this.purchaseList.add(purchase);
    }

}
