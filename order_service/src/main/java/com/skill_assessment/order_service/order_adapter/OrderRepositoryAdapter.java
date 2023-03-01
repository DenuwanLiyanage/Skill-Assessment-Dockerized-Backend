package com.skill_assessment.order_service.order_adapter;

import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import com.skill_assessment.order_service.order_service.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderRepositoryAdapter implements OrderRepository {

    @Autowired
    private OrderJPARepository orderJPARepository;
    @Autowired
    private KafkaTemplate<String, OrderEntity> kafkaTemplate;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public OrderEntity create(Order order) throws Exception {
        try {
            var savedOrder = orderJPARepository.save(orderEntityMapper.map(order));
            log.info("New order saved with id {}", savedOrder.getId());
            kafkaTemplate.send("skillAssessmentTopic", savedOrder);
            return savedOrder;
        } catch (Exception e) {
            log.error("Unable to create an order.", e);
            throw new Exception("Can't create a new order", e);
        }
    }

    @Override
    public List<Order> getAll() throws Exception {
        try{
            var savedOrder = orderJPARepository.findAll();
            ArrayList<Order> orderList = new ArrayList<>();

            for (OrderEntity orderEntity : savedOrder) {
                orderList.add(orderEntityMapper.map(orderEntity));
            }
            return orderList;
        }catch (Exception e){
            log.error("Unable to get all orders.", e);
            throw  new Exception("Can't get all orders",e);
        }
    }

    @Override
    public Order changeStatus(ChangeOrderStatus changeOrderStatus) throws Exception {
        try{
            Integer response = orderJPARepository.updateStatusById(changeOrderStatus.getId(),changeOrderStatus.getOrderStatus().toString());
            if (response>0) {
                var changedOrder = orderJPARepository.getOrderById(changeOrderStatus.getId());
                return orderEntityMapper.map(changedOrder);
            }
            throw new Exception();
        }catch (Exception e){
            log.error("Unable to update status.", e);
            throw  new Exception("Can't update the status",e);
        }
    }
}
