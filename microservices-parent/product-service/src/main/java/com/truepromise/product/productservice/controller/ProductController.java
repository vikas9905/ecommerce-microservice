package com.truepromise.product.productservice.controller;

import com.truepromise.product.productservice.dto.ApiResponse;
import com.truepromise.product.productservice.dto.Product;
import com.truepromise.product.productservice.model.Products;
import com.truepromise.product.productservice.service.ProductService;
import com.truepromise.product.productservice.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public interface ProductController {

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save_product(@RequestBody Products products);
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable String id);

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getProducts();
}
