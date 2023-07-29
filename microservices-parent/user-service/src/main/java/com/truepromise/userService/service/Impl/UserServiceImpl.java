package com.truepromise.userService.service.Impl;

import com.truepromise.userService.dto.ApiResponse;
import com.truepromise.userService.entity.Location;
import com.truepromise.userService.entity.Ratings;
import com.truepromise.userService.entity.User;
import com.truepromise.userService.repository.LocationRepository;
import com.truepromise.userService.repository.RatingsRepository;
import com.truepromise.userService.repository.UserRepository;
import com.truepromise.userService.service.UserService;
import com.truepromise.userService.utils.Responses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RatingsRepository ratingsRepository;
    @Override
    public ResponseEntity<ApiResponse> save_user(User user)  {
        log.info("saving user",user.toString());
        User saved_user =  userRepository.save(user);
        log.info("user saved successfully");
        ApiResponse apiResponse = new ApiResponse(saved_user, HttpStatus.CREATED.value(), Responses.CREATE_SUCCESS,null);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> update_user(User user, long id) {
        User updated_user = userRepository.save(user);
        ApiResponse apiResponse = new ApiResponse(updated_user, HttpStatus.ACCEPTED.value(), Responses.UPDATE_SUCCESS,null);
        return new ResponseEntity<>(apiResponse,HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiResponse> save_location(long id, Location location) {
        User user = userRepository.findById(id).get();
        location.setUser_id(user);
        Location saved_location = locationRepository.save(location);
        ApiResponse apiResponse = new ApiResponse(saved_location, HttpStatus.CREATED.value(), Responses.CREATE_SUCCESS,null);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> save_rating(long id, Ratings ratings) {
        User user = userRepository.findById(id).get();
        ratings.setUser_id(user);
        Ratings saved_ratings = ratingsRepository.save(ratings);
        ApiResponse apiResponse = new ApiResponse(saved_ratings, HttpStatus.CREATED.value(), Responses.CREATE_SUCCESS,null);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> get_users() {
        List<User> user = userRepository.findAll();
        ApiResponse apiResponse = new ApiResponse(user, HttpStatus.ACCEPTED.value(), Responses.GET_SUCCESS,null);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> get_user(long id) {
        log.info("getting users of id: ",id);
        User user = userRepository.findById(id).get();
        log.info("user get success",user.toString());
        ApiResponse apiResponse = new ApiResponse(user, HttpStatus.ACCEPTED.value(), Responses.GET_SUCCESS,null);

        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> get_location(long id) {
        List<Location> locations = locationRepository.getLocationByUserId(id);
        ApiResponse apiResponse = new ApiResponse(locations, HttpStatus.ACCEPTED.value(), Responses.GET_SUCCESS,null);

        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> get_ratings(long id) {
        User user = userRepository.findById(id).get();
        ApiResponse apiResponse = new ApiResponse(user.getRatings(), HttpStatus.ACCEPTED.value(), Responses.GET_SUCCESS,null);

        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
}
