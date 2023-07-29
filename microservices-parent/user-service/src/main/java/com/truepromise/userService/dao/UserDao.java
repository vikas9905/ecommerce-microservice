package com.truepromise.userService.dao;

import com.truepromise.userService.entity.Location;
import com.truepromise.userService.entity.Ratings;
import com.truepromise.userService.entity.User;
import jakarta.transaction.Transactional;

import java.util.*;

public interface UserDao {
    public User save_user(User user);
    @Transactional
    public User update_user(User user, long id);
    public Location save_location(long id, Location location);
    public Ratings save_rating(long id, Ratings ratings);
    public List<User> get_users();
    public User get_user(long id);
    public List<Location> get_location(long id);
    public List<Ratings> get_ratings(long id);
}
