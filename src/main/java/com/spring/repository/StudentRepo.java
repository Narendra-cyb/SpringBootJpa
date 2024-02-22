package com.spring.repository;

import com.spring.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findByGuardianName(String name);
}
