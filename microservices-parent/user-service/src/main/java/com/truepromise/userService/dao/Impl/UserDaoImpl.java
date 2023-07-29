package com.truepromise.userService.dao.Impl;

import com.truepromise.userService.dao.UserDao;
import com.truepromise.userService.entity.Location;
import com.truepromise.userService.entity.Ratings;
import com.truepromise.userService.entity.User;
import com.truepromise.userService.repository.LocationRepository;
import com.truepromise.userService.repository.RatingsRepository;
import com.truepromise.userService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RatingsRepository ratingsRepository;
    @Override
    public User save_user(User user)  {
        log.info("saving user",user.toString());
        return userRepository.save(user);
    }

    @Override
    public User update_user(User user, long id) {
        User updated_user = userRepository.save(user);
        return updated_user;
    }

    @Override
    public Location save_location(long id, Location location) {
        User user = get_user(id);
        location.setUser_id(user);
        Location saved_location = locationRepository.save(location);
        return saved_location;
    }

    @Override
    public Ratings save_rating(long id, Ratings ratings) {
        User user = userRepository.getReferenceById(id);
        ratings.setUser_id(user);
        Ratings saved_ratings = ratingsRepository.save(ratings);
        return saved_ratings;
    }

    @Override
    public List<User> get_users() {
        List<User> user = userRepository.findAll();
        return user;
    }

    @Override
    public User get_user(long id) {
        User user = userRepository.getById(id);
        return user;
    }

    @Override
    public List<Location> get_location(long id) {
        List<Location> locations = locationRepository.getLocationByUserId(id);
        return locations;
    }

    @Override
    public List<Ratings> get_ratings(long id) {
        User user = userRepository.getReferenceById(id);
        return user.getRatings();
    }
}
