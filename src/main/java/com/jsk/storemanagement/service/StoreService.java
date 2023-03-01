package com.jsk.storemanagement.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.CategoryDao;
import com.jsk.storemanagement.dao.LocationDao;
import com.jsk.storemanagement.dao.ManagerDao;
import com.jsk.storemanagement.dao.StoreDao;
import com.jsk.storemanagement.dto.Category;
import com.jsk.storemanagement.dto.Store;

@Service
public class StoreService {

    @Autowired
    StoreDao storeDao;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    LocationDao locationDao;

    // findbyId store
    public Store findById(int storeId) {
        return storeDao.findById(storeId);
    }

    // insert store
    public String insertStore(Store passStore) {
        if (findById(passStore.getStoreId()) == null) {
            storeDao.insertStore(passStore);
            return "store inserted";
        }
        return "store with this id already exists";
    }

    // update the store
    public String updateStore(Store passStore, int storeId) {
        if (findById(storeId) != null) {
            Store dbStore = findById(storeId);
            if(passStore.getManager() != null){
                if(passStore.getManager().getManagerId() != dbStore.getManager().getManagerId()){
                    managerDao.insertManager(passStore.getManager());
                }
                // if you don't want to insert manager
                // else{
                //     return "manager not found for this store";
                // }
            }
            if(passStore.getLocation() != null) {
                if(passStore.getLocation().getLocationId() != dbStore.getLocation().getLocationId()){
                    locationDao.insertLocation(passStore.getLocation());
                }
                // if you don't want to insert location
                // else{
                //     return "location not found for this store";
                // }
            }
            if(passStore.getCategory() != null){
    
                List<Category> passCategories = passStore.getCategory();
                if (dbStore.getCategory() != null) {
                    List<Category> dbCategories = dbStore.getCategory();
                }

                for(Category passCategory : passCategories){ 
                    if (categoryDao.findById(passCategory.getCategoryId()) == null) {
                        categoryDao.insertCategory(passCategory);
                    }
                }
            }

            storeDao.updateStore(passStore, storeId);
            return "store updated";
        }
        return "store not found with this id";
    }
    

    // delete store
    public String deleteStore(int storeId) {
        if (findById(storeId) != null) {
            storeDao.deleteStore(storeId);
            return "store deleted";
        }
        return "store not found with this id";
    }

    // display store
    public List<Store> displayStore() {
        if (storeDao.displayStore() != null) {
            return storeDao.displayStore();
        }
        return null;
    }

}
