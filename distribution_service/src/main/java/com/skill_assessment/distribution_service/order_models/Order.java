package com.skill_assessment.distribution_service.order_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skill_assessment.distribution_service.order_constants.OrderStatus;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("totalCost")
    private double totalCost;

    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    @JsonProperty("shippingAddressEntity")
    private ShippingAddress shippingAddress;


}
