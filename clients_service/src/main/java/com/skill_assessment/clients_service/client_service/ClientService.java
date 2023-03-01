package com.skill_assessment.clients_service.client_service;

import com.skill_assessment.clients_service.client_models.Client;
import com.skill_assessment.clients_service.client_models.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public interface ClientService {
    Client registerNewClient(Client clientRequest) throws Exception;

    String login(LoginRequest loginRequest) throws Exception;

    boolean validateClient(String authHeader);
}
