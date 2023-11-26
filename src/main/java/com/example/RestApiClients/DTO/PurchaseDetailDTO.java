package com.example.RestApiClients.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;

@AllArgsConstructor
@Data
public class PurchaseDetailDTO {

    private Long purchaseId;
    private String productId;
    private int quantity;
    private BigDecimal totalAmnount;
    private ArrayList<ProductDTO> producsList;

    public PurchaseDetailDTO() {
    }


}
