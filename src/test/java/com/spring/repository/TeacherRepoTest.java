package com.spring.repository;

import com.spring.entities.Course;
import com.spring.entities.Teacher;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo repo;

    @Test
    public void saveTeacher(){
        Course React = Course.builder()
                .title("Node")
                .credit(9)
                .build();

        Course Python = Course.builder()
                .title("Compiler")
                .credit(7)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Rajesh")
                .lastName("Nayak")
//                .courses(List.of(React,Python))
                .build();
        repo.save(teacher);
    }

    @Test
    public void getAll(){
        List<Teacher> all = repo.findAll();
        System.out.println(all);
    }

}