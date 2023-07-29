package com.truepromise.userService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user_id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = true)
    private String landmark;

    @Column(nullable = true)
    private float x_cord;

    @Column(nullable = true)
    private float y_cord;
}
