package com.skill_assessment.order_service.order_resources;

import com.skill_assessment.order_service.order_adapter.OrderEntity;
import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
@CrossOrigin(maxAge = 3600)
public class OrderController {

    @Autowired
    private OrderHandler orderHandler;

    @PostMapping("/new-order")
    public ResponseEntity<OrderEntity> createNewOrder(@RequestBody Order orderRequest, @RequestHeader("Authorization") String authHeader) throws Exception {
        log.info("New order received {}", orderRequest.toString());
        return orderHandler.createNewOrder(orderRequest, authHeader);
    }

    @GetMapping("/all-orders")
    public ResponseEntity<List<Order>> getAllOrders(@RequestHeader("Authorization") String authHeader) throws Exception {
        log.info("Get all orders request received");
        return orderHandler.getAllOrders(authHeader);
    }

    @PatchMapping("/change-status")
    public ResponseEntity<Order> changeOrderStatusById(@RequestBody ChangeOrderStatus changeOrderStatus, @RequestHeader("Authorization") String authHeader) throws Exception {
        log.info("Change order status {}", changeOrderStatus.toString());
        return orderHandler.changeOrderStatusById(changeOrderStatus, authHeader);
    }

}
