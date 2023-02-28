package com.jsk.storemanagement.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Store;
import com.jsk.storemanagement.dto.Category;
import com.jsk.storemanagement.repository.CategoryRepository;
import com.jsk.storemanagement.repository.ManagerRepository;
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
            dbStore.setManager(passStore.getManager());
        }
        if(passStore.getLocation() != null) {
            locationDao.updateLocation(passStore.getLocation(), passStore.getLocation().getLocationId());
            dbStore.setLocation(passStore.getLocation());
        }
        if(passStore.getCategory() != null){

            List<Category> passCategories = passStore.getCategory();
            for(Category category : passCategories){
                categoryDao.updateCategory(category, category.getCategoryId());
            }
            passStore.setCategory(passCategories);
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
