package com.truepromise.userService.repository;

import com.truepromise.userService.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings,Long> {
}
