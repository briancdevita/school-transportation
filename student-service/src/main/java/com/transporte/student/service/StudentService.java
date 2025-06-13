package com.transporte.student.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.transporte.student.model.Student;

import com.transporte.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
       
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

     public Student save (Student student) {
    
        return studentRepository.save(student);
    }

    public List<Student> getStudentsByRouteId(Long routeId) {
        return studentRepository.findByRouteId(routeId);
    }


    
}
