package com.skill_assessment.order_service.order_service;

import com.skill_assessment.order_service.order_adapter.OrderEntity;
import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AuthenticatorWebClient authenticatorWebClient;

    @Override
    public ResponseEntity<OrderEntity> createNewOrder(Order orderRequest, String authHeader) throws Exception {


        var isValidRequest = authenticatorWebClient.isAuthenticated(authHeader);

        if (isValidRequest) {
            return ResponseEntity.status(HttpStatus.OK).body(orderRepository.create(orderRequest));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new OrderEntity());
        }

    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders(String authHeader) throws Exception {

        var isValidRequest = authenticatorWebClient.isAuthenticated(authHeader);

        if (isValidRequest) {
            return ResponseEntity.status(HttpStatus.OK).body(orderRepository.getAll());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ArrayList<>());
        }

    }

    @Override
    public ResponseEntity<Order> changeOrderStatusById(ChangeOrderStatus changeOrderStatus, String authHeader) throws Exception {

        var isValidRequest = authenticatorWebClient.isAuthenticated(authHeader);

        if (isValidRequest) {
            return ResponseEntity.status(HttpStatus.OK).body(orderRepository.changeStatus(changeOrderStatus));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Order());
        }

    }
}
