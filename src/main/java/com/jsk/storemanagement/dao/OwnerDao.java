package com.jsk.storemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsk.storemanagement.dto.Owner;

import com.jsk.storemanagement.repository.OwnerRepository;

@Repository
public class OwnerDao {

    @Autowired
    OwnerRepository ownerRepository;

    // find by id owner
    public Owner findById(int ownerId) {
        Optional<Owner> optional = ownerRepository.findById(ownerId);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // insert method for owner
    public void insertOwner(Owner passOwner) {
        ownerRepository.save(passOwner);
    }

    // update method for owner
    public void updateOwner(Owner passOwner, int ownerId) {
        Owner dbOwner = ownerRepository.findById(ownerId).get();

        if (passOwner.getOwnerName() != null) {
            dbOwner.setOwnerName(passOwner.getOwnerName());
        }

        if (passOwner.getOwnerEmail() != null) {
            dbOwner.setOwnerEmail(passOwner.getOwnerEmail());
        }
        ownerRepository.save(dbOwner);
    }

    // delete method for owner
    public void deleteProduct(int ownerId) {
        ownerRepository.deleteById(ownerId);

    }

    // display method for owner
    public List<Owner> displayOwner() {
        return ownerRepository.findAll();
    }
}
