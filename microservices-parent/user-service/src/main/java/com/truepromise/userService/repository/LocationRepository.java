package com.truepromise.userService.repository;

import com.truepromise.userService.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    @Query(nativeQuery = true, value = "select c.id from Location c where c.id = :id")
    public List<Location> getLocationByUserId(@Param("id") long id);
}
