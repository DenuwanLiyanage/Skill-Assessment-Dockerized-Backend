package com.skill_assessment.order_service.order_adapter;

import com.skill_assessment.order_service.order_constants.OrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    @Autowired
    private ShippingAddressEntityMapper shippingAddressEntityMapper;

    public OrderEntity map(Order order){
        return OrderEntity.builder()
                .itemName(order.getItemName())
                .quantity(order.getQuantity())
                .totalCost(order.getTotalCost())
                .shippingAddressEntity(shippingAddressEntityMapper.map(order.getShippingAddress()))
                .orderStatus(order.getOrderStatus().toString())
                .build();
    }

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
