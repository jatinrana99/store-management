package com.jsk.storemanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Manager;
import com.jsk.storemanagement.dto.Owner;
import com.jsk.storemanagement.repository.OwnerRepository;

@Repository
public class OwnerDao {

    @Autowired
    OwnerRepository ownerRepository;
    
    //find by id method
    public Owner findById(int id) {
        Optional<Owner> optional = ownerRepository.findById(id);
        if (optional != null) {
            return optional.get();
        }
        return null;
    }
    
    // insert owner method
    public void insertOwner(Owner passOwner) {
        if (findById(passOwner.getOwnerId()) != null) {
            ownerRepository.save(passOwner);
        }
    }
    
    // update owner method
    public void updateOwner(int id, Owner passOwner) {
        
        if (findById(id) != null) {
            Owner dbOwner = findById(id);
            if (passOwner.getOwnerName() != null) {
                dbOwner.setOwnerName(passOwner.getOwnerName());
            }
            if (passOwner.getOwnerEmail() != null) {
                dbOwner.setOwnerEmail(passOwner.getOwnerEmail());
            }
            if (passOwner.getManager() != null) {
                Manager dbManager = dbOwner.getManager();
                Manager passManager = passOwner.getManager();
                // if ( != null) {
                    
                // }
            }
            // ownerRepository.save(dbOwner);
        }
    }
     
}
