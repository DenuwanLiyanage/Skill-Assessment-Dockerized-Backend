package com.skill_assessment.distribution_service.order_adapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Table(name = "shipping_addresses_table")
public class ShippingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String no;
    private String street;
    private String city;
    private String postalCode;


    @OneToOne(mappedBy = "shippingAddressEntity")
    @JsonIgnore
    private OrderEntity orderEntity;
}

