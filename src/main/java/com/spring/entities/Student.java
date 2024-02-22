package com.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="studentAlt",
            uniqueConstraints = @UniqueConstraint(name = "emailId_unique",columnNames = "emailId"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq",allocationSize = 1,sequenceName = "student_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Integer id;
    private String name;

    @Column(name = "emailId",nullable = false)
    private String email;
    private String college;

    @Embedded
    private Guardian guardian;
}
