package com.truepromise.product.productservice.repository;

import com.truepromise.product.productservice.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Products,String> {
}
