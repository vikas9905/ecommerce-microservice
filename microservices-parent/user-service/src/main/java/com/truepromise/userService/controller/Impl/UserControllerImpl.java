package com.truepromise.userService.controller.Impl;

import com.truepromise.userService.controller.UserControllerInterface;
import com.truepromise.userService.dto.ApiResponse;
import com.truepromise.userService.entity.Location;
import com.truepromise.userService.entity.Ratings;
import com.truepromise.userService.entity.User;
import com.truepromise.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserControllerInterface {

    @Autowired
    private UserService userService;
    @Override
    public String test() {
        return "Hi I am in User Service";
    }

    @Override
    public ResponseEntity<ApiResponse> get_user(@PathVariable long id) {
        return userService.get_user(id);
    }

    @Override
    public ResponseEntity<ApiResponse> get_users() {
        return userService.get_users();
    }

    @Override
    public ResponseEntity<ApiResponse> get_user_location(@PathVariable long id) {
        return userService.get_location(id);
    }

    @Override
    public ResponseEntity<ApiResponse> get_user_ratings(@PathVariable long id) {
        return userService.get_ratings(id);
    }

    @Override
    public ResponseEntity<ApiResponse> save_user(@RequestBody User user) {
        return userService.save_user(user);
    }

    @Override
    public ResponseEntity<ApiResponse> update_user(@PathVariable long id, @RequestBody User user) {
        return userService.update_user(user,id);
    }

    @Override
    public ResponseEntity<ApiResponse> save_user_location(@PathVariable long id, @RequestBody Location location) {
        return userService.save_location(id,location);
    }

    @Override
    public ResponseEntity<ApiResponse> save_rating(@PathVariable long id, @RequestBody Ratings rating) {
        return userService.save_rating(id,rating);
    }
}
