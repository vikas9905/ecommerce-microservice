package com.truepromise.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cooking_details")
public class CookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long product_id;
    private String food_test;
    private String cook_time;
    private String food_type;  // having gravy, fried
    private String food_cooking_style; // like handi chicken, champaran mutton

    @JoinColumn(name = "cooking_details", nullable = false)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private OrderDetails orderDetails;
}
