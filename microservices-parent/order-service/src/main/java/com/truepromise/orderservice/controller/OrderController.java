package com.truepromise.orderservice.controller;

import com.truepromise.orderservice.dto.ApiResponse;
import com.truepromise.orderservice.entity.CookingDetails;
import com.truepromise.orderservice.entity.Order;
import com.truepromise.orderservice.entity.OrderDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public interface OrderController {

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save_orders(@RequestBody Order order);

    @PostMapping("/order_details/save")

    public ResponseEntity<ApiResponse> save_order_details(@RequestBody OrderDetails orderDetails);

    @PostMapping("/cooking_details/save")
    public ResponseEntity<ApiResponse> save_cooking_details(@RequestBody CookingDetails cookingDetails);

    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse> get_orders_of_user(@PathVariable  long id);

    @GetMapping("/order_details/{id}")
    public ResponseEntity<ApiResponse> get_cooking_details_of_order(@PathVariable long order_details_id);

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get_order_details_of_order(@PathVariable long order_id);
}
