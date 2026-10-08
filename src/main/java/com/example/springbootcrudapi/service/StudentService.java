package com.example.springbootcrudapi.service;

import com.example.springbootcrudapi.entity.Student;
import com.example.springbootcrudapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        student.setDeleted(false);
        Student studentResp = studentRepository.save(student);
        return studentResp;
    }

    public List<Student> getStudent() {
        List<Student> studentList = studentRepository.findAllByDeletedFalse();
        return studentList;
    }

    public Student getStudentByID(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeletedFalse(id);

        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> studentRes = studentRepository.findByIdAndDeletedFalse(id);

        if (studentRes.isEmpty()) {
            return null;
        }

        Student studentToSave = studentRes.get();

        studentToSave.setName(student.getName());
        studentToSave.setRollNo(student.getRollNo());
        studentToSave.setSubject(student.getSubject());
        studentToSave.setAge(student.getAge());
        studentToSave.setEmail(student.getEmail());

        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty()) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }

    public boolean deleteStudentSoft(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeletedFalse(id);
        if (student.isEmpty()) {
            return false;
        }

        Student studentRes = student.get();
        studentRes.setDeleted(true);
        studentRepository.save(studentRes);

        return true;

    }

}
