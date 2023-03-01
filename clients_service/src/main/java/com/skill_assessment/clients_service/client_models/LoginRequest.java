package com.skill_assessment.clients_service.client_models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {
    private String username;
    private String password;
}
