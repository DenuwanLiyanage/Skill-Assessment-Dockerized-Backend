package com.skill_assessment.order_service.order_adapter;

import com.skill_assessment.order_service.order_constants.OrderStatus;
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
    private String orderStatus = OrderStatus.NEW.toString();

    @NonNull
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST)
    private ShippingAddressEntity shippingAddressEntity;
}
