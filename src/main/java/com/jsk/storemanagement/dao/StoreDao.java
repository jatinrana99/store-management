package com.jsk.storemanagement.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Store;
import com.jsk.storemanagement.repository.StoreRepository;

@Repository
public class StoreDao {

    @Autowired
    StoreRepository storeRepository;

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
        if(passStore.getStoreLocation() != null){
            dbStore.setStoreLocation(passStore.getStoreLocation());
        }
        storeRepository.save(dbStore);
    }
    // delete store
    public void deleteStore(Store passStore){
        storeRepository.delete(passStore);
    }
    // display store
    public List<Store> displayStore(){
        return storeRepository.findAll();
    }
}
