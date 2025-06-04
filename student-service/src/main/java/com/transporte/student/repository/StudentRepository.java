package com.transporte.student.repository;

import org.springframework.stereotype.Repository;

import com.transporte.student.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
