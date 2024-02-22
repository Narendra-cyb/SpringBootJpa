package com.spring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")

public class CourseMaterial {

    @Id
    @SequenceGenerator(sequenceName = "course_material_Seq",name = "course_mat_seq",allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_mat_seq")
    private Long id;
    private String url;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;
}
