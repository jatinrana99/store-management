package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.ManagerDao;
import com.jsk.storemanagement.dao.StoreDao;
import com.jsk.storemanagement.dto.Manager;
import com.jsk.storemanagement.dto.Store;

@Service
public class ManagerService {

    @Autowired
    ManagerDao managerDao;

    @Autowired
    StoreDao storeDao;

    // find by id manager
    public Manager findById(int managerId) {
        return managerDao.findById(managerId);
    }

    // insert method for manager
    public String insertManager(Manager passManager) {
        if (findById(passManager.getManagerId()) != null) {
            managerDao.insertManager(passManager);
            return "Manager Inserted";
        }
        return "Manager with this id already exists";
    }

    // update method for manager
    public void updateManager(Manager passManager, int managerId) {
        if (findById(managerId) != null) {
            Manager dbManager = findById(managerId);

            List<Store> passStores = passManager.getStore();
            if (passManager.getStore() != null) {
                List<Store> dbstores = dbManager.getStore();
            }

            for (Store passStore : passStores) {
                if (storeDao.findById(passStore.getStoreId()) == null) {
                    storeDao.insertStore(passStore);
                }
            }
        }

        managerDao.updateManager(passManager, managerId);
    }

    // delete method for manager
    public String deleteManager(int managerId) {
        if (findById(managerId) != null) {
            managerDao.deleteManager(managerId);
            return "Manager Deleted";
        }
        return "Manager with this id does not exist";
    }

    // display method for manager
    public List<Manager> displayManager() {
        if (managerDao.displayManager() != null) {
            return managerDao.displayManager();
        }
        return null;
    }
}
