package com.example.springbootcrudapi.controller;

import com.example.springbootcrudapi.entity.Student;
import com.example.springbootcrudapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(createdStudent);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> listOfStudent = studentService.getStudent();
        return ResponseEntity.status(HttpStatus.OK).body(listOfStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Long id) {
        Student student = studentService.getStudentByID(id);
        if (student == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

}
