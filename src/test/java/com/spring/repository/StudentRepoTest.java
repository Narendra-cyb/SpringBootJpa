package com.spring.repository;

import com.spring.entities.Guardian;
import com.spring.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepoTest {


    @Autowired
    private StudentRepo repo;


    @Test
    public void saveStudent() {
        Guardian guardian = new Guardian();
        guardian.setName("Dulendra");
        guardian.setMobile("8144540558");
        guardian.setEmail("jojo@gmail.com");
        Student student = Student.builder().name("Narendra").email("nare@gmail.com").college("IGIT").guardian(guardian).build();
        repo.save(student);
    }


    @Test
    public void PrintStudent() {
        Student st = repo.findByGuardianName("Dulendra");
        System.out.println(st);
    }
}