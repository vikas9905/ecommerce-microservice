package com.truepromise.orderservice.controller.Impl;

import com.truepromise.orderservice.controller.OrderController;
import com.truepromise.orderservice.dto.ApiResponse;
import com.truepromise.orderservice.entity.CookingDetails;
import com.truepromise.orderservice.entity.Order;
import com.truepromise.orderservice.entity.OrderDetails;
import com.truepromise.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;
    @Override
    public ResponseEntity<ApiResponse> save_orders(@RequestBody Order order) {
        return orderService.save_orders(order);
    }

    @Override
    public ResponseEntity<ApiResponse> save_order_details( @RequestBody OrderDetails orderDetails) {
        return orderService.save_order_details(orderDetails);
    }

    @Override
    public ResponseEntity<ApiResponse> save_cooking_details(@RequestBody CookingDetails cookingDetails) {
        return orderService.save_cooking_details(cookingDetails);
    }

    @Override
    public ResponseEntity<ApiResponse> get_orders_of_user(@PathVariable long id) {
        return orderService.get_orders_of_user(id);
    }

    @Override
    public ResponseEntity<ApiResponse> get_cooking_details_of_order(@PathVariable long order_details_id) {
        return orderService.get_cooking_details_of_order(order_details_id);
    }

    @Override
    public ResponseEntity<ApiResponse> get_order_details_of_order(@PathVariable long order_id) {
        return get_order_details_of_order(order_id);
    }
}
