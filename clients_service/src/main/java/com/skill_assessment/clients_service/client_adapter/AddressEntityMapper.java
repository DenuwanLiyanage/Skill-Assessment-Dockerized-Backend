package com.skill_assessment.clients_service.client_adapter;

import com.skill_assessment.clients_service.client_models.ClientAddress;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityMapper {
    public ClientAddress map(AddressEntity addressEntity) {
        return ClientAddress.builder()
                .no(addressEntity.getNo())
                .street(addressEntity.getStreet())
                .city(addressEntity.getCity())
                .postalCode(addressEntity.getPostalCode())
                .build();
    }

    public AddressEntity map(ClientAddress address) {
        return AddressEntity.builder()
                .no(address.getNo())
                .street(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .build();
    }
}
