package com.skill_assessment.order_service.order_adapter;

import com.skill_assessment.order_service.order_models.ShippingAddress;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressEntityMapper {

    public ShippingAddressEntity map(ShippingAddress shippingAddress){
        return ShippingAddressEntity.builder()
                .no(shippingAddress.getNo())
                .city(shippingAddress.getCity())
                .street(shippingAddress.getStreet())
                .postalCode(shippingAddress.getPostalCode())
                .build();
    }

    public ShippingAddress map(ShippingAddressEntity shippingAddressEntity){
        return ShippingAddress.builder()
                .no(shippingAddressEntity.getNo())
                .city(shippingAddressEntity.getCity())
                .street(shippingAddressEntity.getStreet())
                .postalCode(shippingAddressEntity.getPostalCode())
                .build();
    }
}
