package com.jsk.storemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsk.storemanagement.dao.ProductDao;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;
    
}
