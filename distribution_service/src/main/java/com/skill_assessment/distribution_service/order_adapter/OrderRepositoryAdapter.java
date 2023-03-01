package com.skill_assessment.distribution_service.order_adapter;


import com.skill_assessment.distribution_service.order_constants.OrderStatus;
import com.skill_assessment.distribution_service.order_models.ChangeOrderStatus;
import com.skill_assessment.distribution_service.order_models.Order;
import com.skill_assessment.distribution_service.order_service.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class OrderRepositoryAdapter implements OrderRepository {

    @Autowired
    private OrderJPARepository orderJPARepository;


    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public Order changeStatus(ChangeOrderStatus changeOrderStatus) throws Exception {

        var savedOrder = orderJPARepository.getOrderById(changeOrderStatus.getId());
        if(savedOrder.getOrderStatus().equalsIgnoreCase(OrderStatus.NEW.toString())){
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
        }else{
            throw  new Exception("Selected order is not a new order");
        }

    }
}
