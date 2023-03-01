package com.skill_assessment.order_service.order_resources;

import com.skill_assessment.order_service.order_adapter.OrderEntity;
import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import com.skill_assessment.order_service.order_service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    public ResponseEntity<OrderEntity> createNewOrder(Order orderRequest, String authHeader) throws Exception {
        return orderService.createNewOrder(orderRequest, authHeader);
    }

    public ResponseEntity<List<Order>> getAllOrders(String authHeader) throws Exception {
        return orderService.getAllOrders(authHeader);
    }

    public ResponseEntity<Order> changeOrderStatusById(ChangeOrderStatus changeOrderStatus, String authHeader) throws Exception {
        return orderService.changeOrderStatusById(changeOrderStatus, authHeader);
    }
}
