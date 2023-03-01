package com.skill_assessment.order_service.order_service;

import com.skill_assessment.order_service.order_adapter.OrderEntity;
import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository {
    OrderEntity create(Order order) throws Exception;

    List<Order> getAll() throws Exception;

    Order changeStatus(ChangeOrderStatus changeOrderStatus) throws Exception;
}
