package com.spring.repository;

import com.spring.entities.Course;
import com.spring.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void getCourseAll(){
        List<Course> all = courseRepo.findAll();
        System.out.println(all);

    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Manmohan")
                .lastName("Mishra")
                .build();

        Course course  = Course.builder()
                .title("MongoDb")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }

}