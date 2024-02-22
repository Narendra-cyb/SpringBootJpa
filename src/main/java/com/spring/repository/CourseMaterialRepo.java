package com.spring.repository;

import com.spring.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepo extends JpaRepository<CourseMaterial,Long> {
}
