package com.skill_assessment.distribution_service.order_adapter;

import com.skill_assessment.distribution_service.order_models.ShippingAddress;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressEntityMapper {

    public ShippingAddress map(ShippingAddressEntity shippingAddressEntity){
        return ShippingAddress.builder()
                .no(shippingAddressEntity.getNo())
                .city(shippingAddressEntity.getCity())
                .street(shippingAddressEntity.getStreet())
                .postalCode(shippingAddressEntity.getPostalCode())
                .build();
    }
}
