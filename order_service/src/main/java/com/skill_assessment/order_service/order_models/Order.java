package com.skill_assessment.order_service.order_models;

import com.skill_assessment.order_service.order_constants.OrderStatus;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String itemName;
    private int quantity;
    private double totalCost;
    private ShippingAddress shippingAddress;
    private OrderStatus orderStatus;
}
