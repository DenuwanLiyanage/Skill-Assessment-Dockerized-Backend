package com.skill_assessment.clients_service.client_service;

import com.skill_assessment.clients_service.client_models.Client;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepository {
    Client create(Client client) throws Exception;

    Client getClient(String username);
}
