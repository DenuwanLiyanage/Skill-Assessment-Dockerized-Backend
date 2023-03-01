package com.skill_assessment.distribution_service.order_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {

    @JsonProperty("no")
    private String no;

    @JsonProperty("street")
    private String street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("postalCode")
    private String postalCode;
}
