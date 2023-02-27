package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
