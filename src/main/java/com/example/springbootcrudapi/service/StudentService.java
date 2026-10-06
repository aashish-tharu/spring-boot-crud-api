package com.example.springbootcrudapi.service;

import com.example.springbootcrudapi.entity.Student;
import com.example.springbootcrudapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Student> getStudent() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getStudentByID(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> studentRes = studentRepository.findById(id);

        if (studentRes.isEmpty()) {
            return null;
        }

        Student studentToSave = studentRes.get();

        studentToSave.setId(student.getId());
        studentToSave.setName(student.getName());
        studentToSave.setRollNo(student.getRollNo());
        studentToSave.setSubject(student.getSubject());
        studentToSave.setAge(student.getAge());
        studentToSave.setEmail(student.getEmail());

        return studentRepository.save(studentToSave);
    }

}
