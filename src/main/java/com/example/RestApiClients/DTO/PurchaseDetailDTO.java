package com.example.RestApiClients.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;


@NoArgsConstructor
@Data
public class PurchaseDetailDTO {

    private String productId;
    private String productName;
    private Long quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalAmount;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseDetailDTO.class);

    public PurchaseDetailDTO(String productId, String productName, Long quantity, BigDecimal unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = setTotalAmount();
    }

    public BigDecimal setTotalAmount() {
        BigDecimal result;
        result = BigDecimal.valueOf(this.quantity, 1).multiply(this.unitPrice)
                .setScale(2, RoundingMode.HALF_UP);
        return result;
    }

}
