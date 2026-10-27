package com.example.elearning.repository;

import com.example.elearning.entity.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseStatusRepository
        extends JpaRepository<CourseStatus, Long> {

    Optional<CourseStatus> findByStudentIdAndCourse(
            Long studentId,
            String course
    );
}