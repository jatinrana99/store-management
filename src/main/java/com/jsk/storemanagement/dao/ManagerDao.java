package com.jsk.storemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.repository.ManagerRepository;

@Repository
public class ManagerDao {

    @Autowired
    ManagerRepository managerRepository ;
    
}
