package com.example.RestApiClients.DTO;

import com.example.RestApiClients.models.Customer;
import com.example.RestApiClients.models.Purchase;
import com.example.RestApiClients.models.PurchaseDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private BigDecimal payment = BigDecimal.ZERO;
    private List<PurchaseDetailDTO> listPurchaseDetailDTO;
    private Customer customer;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseDTO.class);

    public PurchaseDTO(List<PurchaseDetailDTO> listPurchaseDetailDTO, Customer customer) {
        this.purchaseStatus = "P";
        this.purchaseDate = new Date();
        this.listPurchaseDetailDTO = listPurchaseDetailDTO;
        this.payment = getPayment(listPurchaseDetailDTO);
        this.customer = customer;
    }

    public BigDecimal getPayment(List<PurchaseDetailDTO> listPurchaseDetailDTO) {
        for(PurchaseDetailDTO purchaseDetailDTO : listPurchaseDetailDTO){
            logger.info("El precio del producto es: "+purchaseDetailDTO.getTotalAmount());
        }
        return listPurchaseDetailDTO.stream()
                .map(PurchaseDetailDTO::getTotalAmount)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
