package com.skill_assessment.distribution_service.order_adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface OrderJPARepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity getOrderById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity a SET a.orderStatus = :status WHERE a.id = :id")
    Integer updateStatusById(@Param("id") Long id, @Param("status") String status);
}
