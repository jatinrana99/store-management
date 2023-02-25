package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
