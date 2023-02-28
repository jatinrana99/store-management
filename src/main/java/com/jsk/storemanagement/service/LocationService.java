package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.LocationDao;
import com.jsk.storemanagement.dto.Location;

@Service
public class LocationService {
    @Autowired
    LocationDao locationDao;
     // find by id method of location
     public Location findById(int locationId) {
        
         return locationDao.findById(locationId);
     }
      // insert Location
    public void insertLocation(Location passLocation) {
        locationDao.insertLocation(passLocation);
    }
    // update Location
    public void updateLocation(Location passLocation, int locationId) {
        locationDao.updateLocation(passLocation, locationId);
    }
    // delete Location
    public void deleteLocation(int locationId) {
        locationDao.deleteLocation(locationId);
    }
    // display location
    public List<Location> displayLocation() {
        return locationDao.displayLocation();
    }
    
}
