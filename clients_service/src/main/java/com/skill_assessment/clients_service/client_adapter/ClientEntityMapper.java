package com.skill_assessment.clients_service.client_adapter;

import com.skill_assessment.clients_service.client_models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityMapper {

    @Autowired
    private AddressEntityMapper addressEntityMapper;

    public ClientEntity map(Client client){
        return ClientEntity.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .addressEntity(addressEntityMapper.map(client.getClientAddress()))
                .username(client.getUsername())
                .password(client.getPassword())
                .build();
    }

    public Client map(ClientEntity clientEntity){
        return Client.builder()
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .clientAddress(addressEntityMapper.map(clientEntity.getAddressEntity()))
                .username(clientEntity.getUsername())
                .password(clientEntity.getPassword())
                .build();
    }
}
