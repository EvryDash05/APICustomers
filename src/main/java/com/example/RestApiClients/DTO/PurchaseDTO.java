package com.example.RestApiClients.DTO;

import com.example.RestApiClients.models.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Data
public class PurchaseDTO {

    private String purchaseStatus;
    private Date purchaseDate;
    private BigDecimal payment;
    private List<PurchaseDetailDTO> listPurchaseDetailDTO;
    private Customer customer;

    public PurchaseDTO(List<PurchaseDetailDTO> listPurchaseDetailDTO, Customer customer) {
        this.purchaseStatus = "P";
        this.purchaseDate = new Date();
        this.listPurchaseDetailDTO = listPurchaseDetailDTO;
        this.payment = getPayment(listPurchaseDetailDTO);
        this.customer = customer;
    }

    public BigDecimal getPayment(List<PurchaseDetailDTO> listPurchaseDetailDTO) {
        return listPurchaseDetailDTO.stream().
                map(PurchaseDetailDTO::getTotalAmnount)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
