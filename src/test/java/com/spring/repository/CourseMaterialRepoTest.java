package com.spring.repository;

import com.spring.entities.Course;
import com.spring.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo repo;


    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("DSA")
                .credit(9)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.W3school.in")
                .course(course)
                .build();
        CourseMaterial save = repo.save(courseMaterial);
        System.out.println(save);
    }

    @Test
    public void findCourseMaterial(){
        List<CourseMaterial> all = repo .findAll();
        System.out.println(all);
    }

}