package com.jsk.storemanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Category {
    @Id
    private int catagoryId;
    private String catagoryName;
    private String type;
    @OneToMany
    private Product product;
    @ManyToOne
    private Store store;
    public int getCatagoryId() {
        return catagoryId;
    }
    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }
    public String getCatagoryName() {
        return catagoryName;
    }
    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
}
