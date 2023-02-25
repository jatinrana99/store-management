package com.jsk.storemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.CustomerDao;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
    
}
