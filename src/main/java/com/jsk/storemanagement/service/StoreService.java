package com.jsk.storemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.StoreDao;
import com.jsk.storemanagement.dto.Store;

@Service
public class StoreService {

    @Autowired
    StoreDao storeDao;

    // findbyId store
    public Store findById(int storeId) {
        return storeDao.findById(storeId);
    }

    // insert store
    public void insertStore(Store passStore) {
        storeDao.insertStore(passStore);
    }

    // update the store
    public void updateStore(Store passStore, int storeId) {
        storeDao.updateStore(passStore, storeId);
    }

    // delete store
    public void deleteStore(int storeId) {
        storeDao.deleteStore(storeId);
    }

    // display store
    public List<Store> displayStore() {
        return storeDao.displayStore();
    }

}
