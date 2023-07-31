package com.truepromise.orderservice.repository;

import com.truepromise.orderservice.entity.Order;
import com.truepromise.orderservice.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
    @Query(nativeQuery = true, value = "select * from order_details where order_id = : order_id")
    List<OrderDetails> finAllByOrderId(@Param("order_id") long order_id);
}
