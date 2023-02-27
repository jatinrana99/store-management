package com.jsk.storemanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity
public class Manager {

    @Id
    private int managerId;
    private String managerName;
    private String managerEmail;

    @OneToMany(mappedBy = "manager")
    List<Store> store;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public List<Store> getStore() {
        return store;
    }

    public void setStore(List<Store> store) {
        this.store = store;
    }

}
