package com.jsk.storemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.repository.CustomerRepository;

@Repository
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;
    
}
