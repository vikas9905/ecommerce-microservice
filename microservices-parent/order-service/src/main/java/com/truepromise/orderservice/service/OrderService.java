package com.truepromise.orderservice.service;

import com.truepromise.orderservice.dto.ApiResponse;
import com.truepromise.orderservice.dto.User;
import com.truepromise.orderservice.entity.CookingDetails;
import com.truepromise.orderservice.entity.Order;
import com.truepromise.orderservice.entity.OrderDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public ResponseEntity<ApiResponse> save_orders(Order order);
    public ResponseEntity<ApiResponse> save_order_details(OrderDetails orderDetails);
    public ResponseEntity<ApiResponse> save_cooking_details(CookingDetails cookingDetails);
    public ResponseEntity<ApiResponse> get_orders_of_user(long id);
    public ResponseEntity<ApiResponse> get_cooking_details_of_order(long order_details_id);
    public ResponseEntity<ApiResponse> get_order_details_of_order(long order_id);
}
