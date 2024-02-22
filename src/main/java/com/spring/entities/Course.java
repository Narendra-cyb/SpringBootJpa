package com.spring.entities;

import com.spring.repository.CourseMaterialRepo;
import com.spring.repository.CourseRepo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Course {
    @Id
    @SequenceGenerator(allocationSize = 1,sequenceName = "course_seq",name = "course_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "course_seq")
    private Long id;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",
    referencedColumnName = "tid")
    private Teacher teacher;
}
