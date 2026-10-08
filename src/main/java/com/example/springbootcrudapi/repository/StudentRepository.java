package com.example.springbootcrudapi.repository;

import com.example.springbootcrudapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByDeletedFalse();
    Optional<Student> findByIdAndDeletedFalse(Long id);
}
