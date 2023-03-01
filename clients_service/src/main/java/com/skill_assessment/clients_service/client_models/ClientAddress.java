package com.skill_assessment.clients_service.client_models;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientAddress {

    private String no;
    private String street;
    private String city;
    private String postalCode;
}
