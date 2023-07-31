package com.truepromise.orderservice.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class User {

    private long user_id;
    private String name;
    private String mob_num;
    private String email;
    private String age;
//    private List<Ratings> ratings;
//    //
//    @OneToMany(mappedBy="user_id")
//    private List<Location> locations;
}
