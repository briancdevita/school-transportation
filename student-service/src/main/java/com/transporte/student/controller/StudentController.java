package com.transporte.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.student.event.StudentCreatedEvent;
import com.transporte.student.model.Student;
import com.transporte.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private KafkaTemplate<String, StudentCreatedEvent> kafkaTemplate;

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student createdStudent = studentService.save(student);
        StudentCreatedEvent event = new StudentCreatedEvent(createdStudent.getId(), createdStudent.getFirstName());
        kafkaTemplate.send("student-created", event);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    
}
