package com.transporte.student.repository;

import org.springframework.stereotype.Repository;

import com.transporte.student.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByRouteId(Long routeId);
    
}
