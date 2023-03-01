package com.skill_assessment.order_service.order_models;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {

    private String no;
    private String street;
    private String city;
    private String postalCode;
}
