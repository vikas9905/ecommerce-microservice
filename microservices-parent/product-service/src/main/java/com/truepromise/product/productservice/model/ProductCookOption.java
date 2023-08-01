package com.truepromise.product.productservice.model;

import lombok.Data;

import java.util.*;

@Data
public class ProductCookOption {
    private List<String> food_test;
    private List<String> food_type;
    private List<String> cook_type;

    private Map<String,Integer> food_cooking_style;
}
