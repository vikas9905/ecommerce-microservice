package com.truepromise.orderservice.repository;

import com.truepromise.orderservice.entity.CookingDetails;
import com.truepromise.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookingDetailsRepository extends JpaRepository<CookingDetails,Long> {
    @Query(nativeQuery = true, value = "select * from cooking_details where order_details_id = :order_details_id ")
    CookingDetails findByOrderDetailsId(@Param("order_details_id") long order_details_id);
}
