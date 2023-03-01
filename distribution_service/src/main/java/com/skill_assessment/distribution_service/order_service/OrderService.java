package com.skill_assessment.distribution_service.order_service;


import com.skill_assessment.distribution_service.order_models.ChangeOrderStatus;
import com.skill_assessment.distribution_service.order_models.Order;
import org.springframework.stereotype.Component;


@Component
public interface OrderService {

    Order changeOrderStatusById(ChangeOrderStatus changeOrderStatus) throws Exception;
}
