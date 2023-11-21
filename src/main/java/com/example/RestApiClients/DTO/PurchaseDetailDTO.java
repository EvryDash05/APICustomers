package com.example.RestApiClients.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseDetailDTO {

    private int quantity;
    private BigDecimal totalAmnount;

    public PurchaseDetailDTO(PurchaseDTO purchaseDTO) {
        this.quantity = 1;
        this.totalAmnount = new BigDecimal(123.2);
    }

    /*public int quantity(ArrayList<ProductDTO> productsList) {
        int quantity = productsList.stream().map(p -> p.getProductId())
                .filter().count();

        return quantity;
    }*/



}
