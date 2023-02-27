package com.jsk.storemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.jsk.storemanagement.dto.Location;
import com.jsk.storemanagement.repository.LocationRepository;
import java.util.List;

@Repository
public class LocationDao {

    @Autowired
    LocationRepository locationRepository;

    // find by id method of location
    public Location findById(int locationId) {
        Optional<Location> optional = locationRepository.findById(locationId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    // insert Location
    public void insertLocation(Location passLocation) {
        locationRepository.save(passLocation);
    }

    // update Location
    public void updateLocation(Location passLocation, int locationId) {
        Location dbLocation = locationRepository.findById(locationId).get();

        if (passLocation.getLocationName() != null) {
            dbLocation.setLocationName(passLocation.getLocationName());
        }
        if (passLocation.getLocationLocality() != null) {
            dbLocation.setLocationLocality(passLocation.getLocationLocality());
        }
        if (passLocation.getLocationPin() != 0) {
            dbLocation.setLocationPin(passLocation.getLocationPin());
        }
        if (passLocation.getLocationState() != null) {
            dbLocation.setLocationState(passLocation.getLocationState());
        }
        locationRepository.save(dbLocation);

    }

    // delete Location
    public void deleteLocation(int locationId) {
        locationRepository.deleteById(locationId);
    }

    // display location
    public List<Location> displayLocation() {
        return locationRepository.findAll();
    }

}
