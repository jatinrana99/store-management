package com.jsk.storemanagement.dto;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    private int productId;
    private String productName;
    private double productPrice;
    private boolean productAvailability;
    private String productQuantity;
    private LocalDateTime productAddedTime;
    @ManyToOne
    private Category category;
public int getProductId() {
    return productId;
}
public void setProductId(int productId) {
    this.productId = productId;
}
public String getProductName() {
    return productName;
}
public void setProductName(String productName) {
    this.productName = productName;
}
public double getProductPrice() {
    return productPrice;
}
public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
}
public boolean getProductAvailability() {
    return productAvailability;
}
public void setProductAvailability(boolean productAvailability) {
    this.productAvailability = productAvailability;
}
public Category getCategory() {
    return Category;
}
public void setCategory(Category Category) {
    this.Category = Category;
}
}
