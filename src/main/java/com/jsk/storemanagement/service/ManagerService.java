package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.ManagerDao;
import com.jsk.storemanagement.dto.Manager;

@Service
public class ManagerService {

    @Autowired
    ManagerDao managerDao;
    // find by id manager
    public Manager findById(int managerId) {
       return managerDao.findById(managerId);
    }

    // insert method for manager
    public void insertManager(Manager passManager) {
        managerDao.insertManager(passManager);
    }

    // update method for manager
    public void updateManager(Manager passManager, int managerId) {
        managerDao.updateManager(passManager, managerId);
    }

    // delete method for manager
    public void deleteManager(int managerId) {
        managerDao.deleteManager(managerId);
    }

    // display method for manager
    public List<Manager> displayManager() {
        return managerDao.displayManager();
    }
}
