package com.skill_assessment.distribution_service.order_adapter;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders_table")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private int quantity;
    private double totalCost;
    private String orderStatus;

    @NonNull
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST)
    private ShippingAddressEntity shippingAddressEntity;
}
