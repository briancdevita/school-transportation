package com.stop_service.stop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stop_service.stop_service.model.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {
    // Additional query methods can be defined here if needed
    
}
