package com.truepromise.product.productservice.serviceImpl;

import com.truepromise.product.productservice.dto.ApiResponse;
import com.truepromise.product.productservice.dto.Product;
import com.truepromise.product.productservice.model.Products;
import com.truepromise.product.productservice.repository.ProductRepo;
import com.truepromise.product.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ResponseEntity<ApiResponse> save_product(Products product) {
        try{
            log.info("saving Product...");
            productRepo.save(product);
            log.info("Product Saved");
            return new ResponseEntity<>(new ApiResponse(201,"Product Created Successfully"), HttpStatusCode.valueOf(201));
        }catch (Exception e) {
            log.error("Product saving error occured...",e);
            return new ResponseEntity<>(new ApiResponse(201,"Product Creation Failed"), HttpStatusCode.valueOf(500));
        }
    }

    @Override
    public List<Products> getProducts() {
        List<Products> products = productRepo.findAll();
        System.out.println(products);
        return products;
    }

    @Override
    public Products getProductById(String product_id) {
        Products products = productRepo.findById(product_id).orElseThrow();
        return products;
    }
}
