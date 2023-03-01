package com.skill_assessment.clients_service.client_resources;

import com.skill_assessment.clients_service.client_models.Client;
import com.skill_assessment.clients_service.client_models.LoginRequest;
import com.skill_assessment.clients_service.client_service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientHandler {

    @Autowired
    private ClientService clientService;

    public Client registerNewClient(Client clientRequest) throws Exception {
        return clientService.registerNewClient(clientRequest);
    }

    public String login(LoginRequest loginRequest) throws Exception {
        return clientService.login(loginRequest);
    }

    public boolean validateClient(String authHeader) {
        return clientService.validateClient(authHeader);
    }
}
