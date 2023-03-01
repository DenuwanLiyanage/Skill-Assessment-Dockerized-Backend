package com.skill_assessment.distribution_service.order_service;


import com.skill_assessment.distribution_service.order_models.ChangeOrderStatus;
import com.skill_assessment.distribution_service.order_models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order changeOrderStatusById(ChangeOrderStatus changeOrderStatus) throws Exception {
        return orderRepository.changeStatus(changeOrderStatus);
    }
}
