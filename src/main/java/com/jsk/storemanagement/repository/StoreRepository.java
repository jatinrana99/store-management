package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Store;

public interface StoreRepository extends JpaRepository<Store,Integer> {
    
}
