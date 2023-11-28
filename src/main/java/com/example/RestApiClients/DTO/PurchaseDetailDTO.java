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
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalAmnount;
    private static Logger logger = LoggerFactory.getLogger(PurchaseDetailDTO.class);

    public PurchaseDetailDTO(String productId, String productName, Integer quantity, BigDecimal unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = (quantity != null) ? quantity : 0;
        if(this.quantity == null) {
            logger.info("no hay pe xd");
        }
        this.unitPrice = (unitPrice != null) ? unitPrice : BigDecimal.ZERO;
        setTotalAmnount(quantity, unitPrice);
    }

    public void setTotalAmnount(Integer quantity, BigDecimal unitPrice) {
         this.totalAmnount = BigDecimal.valueOf(quantity).multiply(unitPrice)
                .setScale(2, RoundingMode.HALF_UP);
    }

}
