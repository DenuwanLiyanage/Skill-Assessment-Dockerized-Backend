package com.skill_assessment.distribution_service.kafka_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skill_assessment.distribution_service.order_constants.OrderStatus;
import com.skill_assessment.distribution_service.order_models.ChangeOrderStatus;
import com.skill_assessment.distribution_service.order_models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListener {

    @Autowired
    private OrderHandler orderHandler;

    @org.springframework.kafka.annotation.KafkaListener(topics = "skillAssessmentTopic",groupId = "group")
    void listener(String data) throws Exception {
        log.info("Data received {}", data);

        var changeStatus = new ChangeOrderStatus();

        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(data, Order.class);

        changeStatus.setId(order.getId());
        changeStatus.setOrderStatus(OrderStatus.DISPATCHED);

        log.info(changeStatus.toString());
        var changedOrder = orderHandler.changeOrderStatusById(changeStatus);
        log.info("Order setup to dispatch {}", changedOrder);
    }
}
