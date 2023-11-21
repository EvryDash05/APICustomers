package com.example.RestApiClients.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private String productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private int quantity;

}
