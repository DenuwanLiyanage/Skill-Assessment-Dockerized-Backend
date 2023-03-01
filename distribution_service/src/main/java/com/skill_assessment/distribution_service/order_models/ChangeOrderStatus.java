package com.skill_assessment.distribution_service.order_models;

import com.skill_assessment.distribution_service.order_constants.OrderStatus;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChangeOrderStatus {

    private Long id;
    private OrderStatus orderStatus;
}
