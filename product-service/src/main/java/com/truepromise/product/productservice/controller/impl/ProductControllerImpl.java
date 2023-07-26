package com.truepromise.product.productservice.controller.impl;

import com.truepromise.product.productservice.controller.ProductController;
import com.truepromise.product.productservice.dto.ApiResponse;
import com.truepromise.product.productservice.model.Products;
import com.truepromise.product.productservice.service.ProductService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Builder
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;
    @Override
    public ResponseEntity<ApiResponse> save_product(@RequestBody Products products) {
        System.out.println(products.toString());
        return productService.save_product(products);
    }

    @Override
    public ResponseEntity<ApiResponse> getProduct(@PathVariable String id) {
        return new ResponseEntity<>(new ApiResponse(200,"Record Fetched Success",null,productService.getProductById(id)), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<ApiResponse> getProducts() {
        return new ResponseEntity<>(new ApiResponse(200,"Record Fetched Success",null,productService.getProducts()), HttpStatusCode.valueOf(200));
    }
}
