package com.jsk.storemanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Store {
    @Id
    private int storeId;
    private String storeName;
    private String storeSize;
    private String storeLocation;
    @ManyToOne
    private Manager owner;
    @OneToMany
    private Product product;
    
    public String getStoreLocation() {
        return storeLocation;
    }
    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
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

    public Manager getOwner() {
        return owner;
    }
    public void setOwner(Manager owner) {
        this.owner = owner;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
