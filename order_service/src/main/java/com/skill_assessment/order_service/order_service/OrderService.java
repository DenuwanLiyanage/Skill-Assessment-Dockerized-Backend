package com.skill_assessment.order_service.order_service;

import com.skill_assessment.order_service.order_adapter.OrderEntity;
import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    ResponseEntity<OrderEntity> createNewOrder(Order orderRequest, String authHeader) throws Exception;

    ResponseEntity<List<Order>> getAllOrders(String authHeader) throws Exception;

    ResponseEntity<Order> changeOrderStatusById(ChangeOrderStatus changeOrderStatus, String authHeader) throws Exception;
}
