package com.truepromise.userService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rating_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user_id;

    @Column(nullable = true)
    private String comment;

    @Column(nullable = true)
    private long rating;

}
