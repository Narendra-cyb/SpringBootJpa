package com.spring.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(initialValue = 1,allocationSize = 1,sequenceName = "teacher_seq",name = "teacher_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_seq")
    private Long tid;

    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",referencedColumnName = "tid")
    private List<Course> courses;
}
