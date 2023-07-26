package com.truepromise.product.productservice.service;

import com.truepromise.product.productservice.dto.ApiResponse;
import com.truepromise.product.productservice.dto.Product;
import com.truepromise.product.productservice.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public ResponseEntity<ApiResponse> save_product(Products product);
    public List<Products> getProducts();
    public Products getProductById(String product_id);

}
