package com.truepromise.userService.service;

import com.truepromise.userService.dto.ApiResponse;
import com.truepromise.userService.entity.Location;
import com.truepromise.userService.entity.Ratings;
import com.truepromise.userService.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public ResponseEntity<ApiResponse> save_user(User user);
    public ResponseEntity<ApiResponse> update_user(User user, long id);
    public ResponseEntity<ApiResponse> save_location(long id, Location location);
    public ResponseEntity<ApiResponse> save_rating(long id, Ratings ratings);
    public ResponseEntity<ApiResponse> get_users();
    public ResponseEntity<ApiResponse> get_user(long id);
    public ResponseEntity<ApiResponse> get_location(long id);
    public ResponseEntity<ApiResponse> get_ratings(long id);
}
