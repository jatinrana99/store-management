package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

  

}
