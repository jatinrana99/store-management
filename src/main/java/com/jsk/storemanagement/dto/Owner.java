package com.jsk.storemanagement.dto;

import jakarta.persistence.OneToMany;

public class Owner {
private int ownerId;
private String ownerName;
private String ownerEmail;
@OneToMany
private Store store;
public int getOwnerId() {
    return ownerId;
}
public void setOwnerId(int ownerId) {
    this.ownerId = ownerId;
}
public String getOwnerName() {
    return ownerName;
}
public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
}
public String getOwnerEmail() {
    return ownerEmail;
}
public void setOwnerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
}
public Store getStore() {
    return store;
}
public void setStore(Store store) {
    this.store = store;
}

}
