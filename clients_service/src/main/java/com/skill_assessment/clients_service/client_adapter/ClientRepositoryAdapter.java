package com.skill_assessment.clients_service.client_adapter;

import com.skill_assessment.clients_service.client_models.Client;
import com.skill_assessment.clients_service.client_service.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientRepositoryAdapter implements ClientRepository {

    @Autowired
    private ClientJPARepository clientJPARepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Override
    public Client create(Client client) throws Exception {
        try {
            var savedClient = clientJPARepository.save(clientEntityMapper.map(client));
            return clientEntityMapper.map(savedClient);
        } catch (Exception e) {
            log.error("Unable to create a client.", e);
            throw new Exception("Can't create a new client", e);
        }
    }

    @Override
    public Client getClient(String username) {
        return clientEntityMapper.map(clientJPARepository.getClientByUsername(username));
    }
}
