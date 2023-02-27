package com.jsk.storemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Location;
import com.jsk.storemanagement.repository.LocationRepository;

@Repository
public class LocationDao {
    
    @Autowired
    LocationRepository locationRepository;

    // find by id method of location


    // insert Location
    public void insertLocation(Location passLocation){
        locationRepository.save(passLocation);
    }

}
