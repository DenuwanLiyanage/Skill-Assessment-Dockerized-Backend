package com.skill_assessment.distribution_service.kafka_controller;


import com.skill_assessment.distribution_service.order_models.ChangeOrderStatus;
import com.skill_assessment.distribution_service.order_models.Order;
import com.skill_assessment.distribution_service.order_service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    public Order changeOrderStatusById(ChangeOrderStatus changeOrderStatus) throws Exception {
        return orderService.changeOrderStatusById(changeOrderStatus);
    }
}
