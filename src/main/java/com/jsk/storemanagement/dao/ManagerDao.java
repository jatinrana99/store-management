package com.jsk.storemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Manager;
import com.jsk.storemanagement.dto.Store;
import com.jsk.storemanagement.repository.ManagerRepository;

@Repository
public class ManagerDao {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    StoreDao storeDao;

    // find by id manager
    public Manager findById(int managerId) {
        Optional<Manager> optional = managerRepository.findById(managerId);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // insert method for manager
    public void insertManager(Manager passManager) {
        managerRepository.save(passManager);
    }

    // update method for manager
    public void updateManager(Manager passManager, int managerId) {
        Manager dbManager = managerRepository.findById(managerId).get();

        if (passManager.getManagerName() != null) {
            dbManager.setManagerName(passManager.getManagerName());
        }

        if (passManager.getManagerEmail() != null) {
            dbManager.setManagerEmail(passManager.getManagerEmail());
        }
        // this method is updated
        if (passManager.getStore() != null) {
            List<Store> passStores = passManager.getStore();
            for (Store store : passStores) {
                storeDao.updateStore(store, store.getStoreId());
            }
            dbManager.setStore(passStores);
        }

        managerRepository.save(dbManager);
    }

    // delete method for manager
    public void deleteManager(int managerId) {
        managerRepository.deleteById(managerId);

    }

    // display method for manager
    public List<Manager> displayManager() {
        return managerRepository.findAll();
    }
}
