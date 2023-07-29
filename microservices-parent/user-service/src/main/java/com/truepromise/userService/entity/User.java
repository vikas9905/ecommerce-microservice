package com.truepromise.userService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    private String name;
    private String mob_num;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private String age;

    @OneToMany(mappedBy = "user_id")
    private List<Ratings> ratings;
//
    @OneToMany(mappedBy="user_id")
    private List<Location> locations;

}
