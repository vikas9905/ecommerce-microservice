package com.truepromise.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Data
@Slf4j
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_id", unique = true, nullable = false)
    private String order_id;

    @Column(name = "user_id", nullable = false, unique = false)
    private long user_id;

    @OneToMany(mappedBy = "order_id")
    private List<OrderDetails> order_details;
}
