package com.truepromise.orderservice.service.Impl;

import com.truepromise.orderservice.dto.ApiResponse;
import com.truepromise.orderservice.entity.CookingDetails;
import com.truepromise.orderservice.entity.Order;
import com.truepromise.orderservice.entity.OrderDetails;
import com.truepromise.orderservice.repository.CookingDetailsRepository;
import com.truepromise.orderservice.repository.OrderDetailsRepository;
import com.truepromise.orderservice.repository.OrderRepository;
import com.truepromise.orderservice.service.OrderService;
import com.truepromise.orderservice.utils.Responses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CookingDetailsRepository cookingDetailsRepository;
    @Override
    public ResponseEntity<ApiResponse> save_orders(Order order) {
        log.info("Saving order ",order.toString());
        Order saved_order = orderRepository.save(order);
        log.info("order saved successfully",order.toString());
        ApiResponse resp = new ApiResponse(saved_order, HttpStatus.CREATED.value(), Responses.CREATE_SUCCESS,null);
        return new ResponseEntity<>(resp,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> save_order_details(OrderDetails orderDetails) {
        log.info("Saving orderDetails ",orderDetails.toString());
        OrderDetails saved_order_details = orderDetailsRepository.save(orderDetails);
        log.info("order saved successfully",orderDetails.toString());
        ApiResponse resp = new ApiResponse(saved_order_details, HttpStatus.CREATED.value(), Responses.CREATE_SUCCESS,null);
        return new ResponseEntity<>(resp,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> save_cooking_details(CookingDetails cookingDetails) {
        log.info("Saving orderDetails ",cookingDetails.toString());
        CookingDetails saved_cook_details = cookingDetailsRepository.save(cookingDetails);
        log.info("order saved successfully",cookingDetails.toString());
        ApiResponse resp = new ApiResponse(saved_cook_details, HttpStatus.CREATED.value(), Responses.CREATE_SUCCESS,null);
        return new ResponseEntity<>(resp,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> get_orders_of_user(long id) {
        List<Order> order = orderRepository.findAllByUserId(id);
        ApiResponse resp = new ApiResponse(order, HttpStatus.OK.value(), Responses.GET_SUCCESS,null);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> get_cooking_details_of_order(long order_details_id) {
        CookingDetails cookingDetails = cookingDetailsRepository.findByOrderDetailsId(order_details_id);
        ApiResponse resp = new ApiResponse(cookingDetails, HttpStatus.OK.value(), Responses.GET_SUCCESS,null);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> get_order_details_of_order(long order_id) {
        List<OrderDetails> orderDetails = orderDetailsRepository.finAllByOrderId(order_id);
        ApiResponse resp = new ApiResponse(orderDetails, HttpStatus.OK.value(), Responses.GET_SUCCESS,null);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }
}
