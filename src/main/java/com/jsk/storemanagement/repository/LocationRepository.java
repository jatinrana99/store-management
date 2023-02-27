package com.jsk.storemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsk.storemanagement.dto.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
