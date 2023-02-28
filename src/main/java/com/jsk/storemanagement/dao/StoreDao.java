package com.jsk.storemanagement.dao;

import java.util.Optional;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Store;
import com.jsk.storemanagement.dto.Category;
import com.jsk.storemanagement.repository.StoreRepository;

@Repository
public class StoreDao {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    LocationDao locationDao;

    // find by id
    public Store findById(int storeId) {
        Optional<Store> optional = storeRepository.findById(storeId);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    // insert store
    public void insertStore(Store passStore){
        storeRepository.save(passStore);
    }
    // update store
    public void updateStore(Store passStore, int storeId){

        Store dbStore = storeRepository.findById(storeId).get();
        if(passStore.getStoreName() != null){
            dbStore.setStoreName(passStore.getStoreName());
        }
        if(passStore.getStoreSize() != null){
            dbStore.setStoreSize(passStore.getStoreSize());
        }
        if(passStore.getManager() != null){
            managerDao.updateManager(passStore.getManager() , passStore.getManager().getManagerId());
            dbStore.setManager(managerDao.findById(passStore.getManager().getManagerId()));
        }
        if(passStore.getLocation() != null) {
            locationDao.updateLocation(passStore.getLocation(), passStore.getLocation().getLocationId());
            dbStore.setLocation(locationDao.findById(passStore.getLocation().getLocationId()));
        }
        if(passStore.getCategory() != null){

            List<Category> passCategories = passStore.getCategory();
            List<Category> updatedCategories = new LinkedList<Category>() ;
            for(Category category : passCategories){
                categoryDao.updateCategory(category, category.getCategoryId());
                updatedCategories.add(categoryDao.findById(category.getCategoryId()));
            }
            passStore.setCategory(updatedCategories);
        }
        storeRepository.save(dbStore);
    }

    // delete store
    public void deleteStore(int storeId){
        storeRepository.deleteById(storeId);
    }
    // display store
    public List<Store> displayStore(){
        return storeRepository.findAll();
    }
}
