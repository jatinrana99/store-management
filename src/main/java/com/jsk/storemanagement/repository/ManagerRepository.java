package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Manager;

public interface ManagerRepository extends JpaRepository<Manager , Integer> {

}
