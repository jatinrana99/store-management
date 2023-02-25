package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
