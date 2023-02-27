package com.jsk.storemanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Location {

    @Id
    private int locationId;
    private String locationName;
    private String locationLocality;
    private int locationPin;
    private String locationState;

    @OneToOne
    private Store store;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationLocality() {
        return locationLocality;
    }

    public void setLocationLocality(String locationLocality) {
        this.locationLocality = locationLocality;
    }

    public int getLocationPin() {
        return locationPin;
    }

    public void setLocationPin(int locationPin) {
        this.locationPin = locationPin;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
