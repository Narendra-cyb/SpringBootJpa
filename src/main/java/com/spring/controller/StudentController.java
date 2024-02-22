package com.spring.controller;

import java.util.List;

import com.spring.entities.Course;
import com.spring.exception.ResouceNotFoundHandlerException;
import com.spring.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class StudentController {

    @Autowired
    private CourseRepo repo;

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        Course saved = repo.save(course);
        return new ResponseEntity<Course>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> fetchCourseId(@PathVariable Long id){
        Course course = repo.findById(id).orElseThrow(()-> new ResouceNotFoundHandlerException(id+" Not found"));
        return new ResponseEntity<Course>(course,HttpStatus.OK);
    }
}
