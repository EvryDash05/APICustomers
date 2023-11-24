package com.example.RestApiClients.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private String customerId;
    private String customerName;
    private String customerLastName;
    private String customerDirection;
    private String phoneNumber;

}
