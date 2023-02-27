package com.jsk.storemanagement.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Store {
    @Id
    private int storeId;
    private String storeName;
    private String storeSize;
    @ManyToOne
    private Manager manager;
    @OneToMany
    private List<Product> products;
    @OneToOne
    private Location location;
    
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreSize() {
        return storeSize;
    }
    public void setStoreSize(String storeSize) {
        this.storeSize = storeSize;
    }

    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public List<Product> getProduct() {
        return products;
    }
    public void setProduct(List<Product> products) {
        this.products = products;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
