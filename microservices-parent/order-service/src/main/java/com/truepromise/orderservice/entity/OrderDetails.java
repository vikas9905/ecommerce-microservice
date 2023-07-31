package com.truepromise.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "order_details", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Order order_id;

    private long product_id;
    private long quantity;
    private long unit_id;
    private float amount;
    private long location_id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  CookingDetails cookingDetails;

}
