package com.truepromise.userService.controller;

import com.truepromise.userService.dto.ApiResponse;
import com.truepromise.userService.entity.Location;
import com.truepromise.userService.entity.Ratings;
import com.truepromise.userService.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface UserControllerInterface {
    @GetMapping("/test")
    public String test();

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> get_user(@PathVariable long id);
    @GetMapping("/get")
    public ResponseEntity<ApiResponse> get_users();
    @GetMapping("/location/{id}")
    public ResponseEntity<ApiResponse> get_user_location(@PathVariable long id);
    @GetMapping("/ratings/{id}")
    public ResponseEntity<ApiResponse> get_user_ratings(@PathVariable long id);

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save_user(User user);

    @PostMapping("/save/{id}")
    public ResponseEntity<ApiResponse> update_user(@PathVariable long id, @RequestBody User user);

    @PostMapping("save/{id}/location")
    public ResponseEntity<ApiResponse> save_user_location(@PathVariable long id, @RequestBody Location location);

    @PostMapping("save/{id}/ratings")
    public ResponseEntity<ApiResponse> save_rating(@PathVariable long id, @RequestBody Ratings rating);
}
