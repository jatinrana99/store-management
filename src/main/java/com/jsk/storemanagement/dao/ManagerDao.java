package com.jsk.storemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Manager;
import com.jsk.storemanagement.repository.ManagerRepository;

@Repository
public class ManagerDao {

    @Autowired
    ManagerRepository managerRepository;

    // find by id owner
    public Manager findById(int ownerId) {
        Optional<Manager> optional = managerRepository.findById(ownerId);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // insert method for owner
    public void insertOwner(Manager passOwner) {
        managerRepository.save(passOwner);
    }

    // update method for owner
    public void updateOwner(Manager passOwner, int ownerId) {
        Manager dbOwner = managerRepository.findById(ownerId).get();

        if (passOwner.getManagerName() != null) {
            dbOwner.setManagerName(passOwner.getManagerName());
        }

        if (passOwner.getManagerEmail() != null) {
            dbOwner.setManagerEmail(passOwner.getManagerEmail());
        }
        managerRepository.save(dbOwner);
    }

    // delete method for owner
    public void deleteProduct(int managerId) {
        managerRepository.deleteById(managerId);

    }

    // display method for owner
    public List<Manager> displayManager() {
        return managerRepository.findAll();
    }
}
