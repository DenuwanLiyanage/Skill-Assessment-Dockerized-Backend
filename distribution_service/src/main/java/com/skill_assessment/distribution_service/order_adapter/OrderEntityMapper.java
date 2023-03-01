package com.skill_assessment.distribution_service.order_adapter;


import com.skill_assessment.distribution_service.order_constants.OrderStatus;
import com.skill_assessment.distribution_service.order_models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    @Autowired
    private ShippingAddressEntityMapper shippingAddressEntityMapper;

    public Order map(OrderEntity orderEntity){
        return Order.builder()
                .itemName(orderEntity.getItemName())
                .quantity(orderEntity.getQuantity())
                .totalCost(orderEntity.getTotalCost())
                .shippingAddress(shippingAddressEntityMapper.map(orderEntity.getShippingAddressEntity()))
                .orderStatus(OrderStatus.valueOf(orderEntity.getOrderStatus()))
                .build();
    }
}
