package com.skill_assessment.clients_service.client_models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    private String firstName;
    private String lastName;
    private ClientAddress clientAddress;
    private String username;
    private String password;
}
