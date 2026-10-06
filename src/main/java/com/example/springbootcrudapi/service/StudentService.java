package com.example.springbootcrudapi.service;

import com.example.springbootcrudapi.entity.Student;
import com.example.springbootcrudapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        Student studentResp = studentRepository.save(student);
        return studentResp;
    }

}
