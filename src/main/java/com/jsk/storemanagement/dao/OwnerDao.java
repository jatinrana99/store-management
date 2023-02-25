package com.jsk.storemanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.repository.OwnerRepository;

@Repository
public class OwnerDao {

    @Autowired
    OwnerRepository ownerRepository;
}
