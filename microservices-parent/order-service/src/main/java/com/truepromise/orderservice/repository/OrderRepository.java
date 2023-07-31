package com.truepromise.orderservice.repository;

import com.truepromise.orderservice.entity.Order;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(nativeQuery = true, value = "select * from orders where user_id = : user_id")
    List<Order> findAllByUserId(@Param("user_id") long user_id);
}
