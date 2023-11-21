package com.example.RestApiClients.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {

    private String idClient;
    private String clienteName;
    private String clientLastName;
    private String clientDirection;
    private String phoneNumber;

}
