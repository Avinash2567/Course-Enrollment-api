
        package com.example.elearning.service;

import com.example.elearning.entity.CourseStatus;
import com.example.elearning.repository.CourseStatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class CourseStatusService {

    private final CourseStatusRepository repository;

    public CourseStatusService(CourseStatusRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<CourseStatus> processEnrollments(String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        List<CourseStatus> results = new java.util.ArrayList<>();

        String[] entries = input.split(",");

        for (String entry : entries) {

            String[] studentAndCourse = entry.trim().split(":", -1);

            if (studentAndCourse.length != 2) {
                throw new IllegalArgumentException(
                        "Invalid entry format: " + entry
                );
            }

            String[] studentAndStatus =
                    studentAndCourse[0].trim().split("-", -1);

            if (studentAndStatus.length != 2) {
                throw new IllegalArgumentException(
                        "Invalid student format: " + entry
                );
            }

            String studentText = studentAndStatus[0].trim();
            String course = studentAndStatus[1].trim()
                    .toUpperCase(Locale.ROOT);
            String statusCode = studentAndCourse[1].trim()
                    .toUpperCase(Locale.ROOT);

            if (!studentText.matches("\\d+")) {
                throw new IllegalArgumentException(
                        "Student ID must contain digits only: " + studentText
                );
            }

            Long studentId;

            try {
                studentId = Long.parseLong(studentText);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException(
                        "Student ID is outside the supported range: "
                                + studentText
                );
            }

            if (studentId <= 0) {
                throw new IllegalArgumentException(
                        "Student ID must be positive"
                );
            }

            if (course.isBlank() ||
                    !course.matches("[A-Z0-9_-]+")) {
                throw new IllegalArgumentException(
                        "Invalid course: " + course
                );
            }

            String status;

            switch (statusCode) {
                case "E":
                    status = "ENROLLED";
                    break;

                case "C":
                    status = "COMPLETED";
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Invalid status code: " + statusCode
                    );
            }

            CourseStatus courseStatus =
                    repository.findByStudentIdAndCourse(studentId, course)
                            .orElseGet(
                                    () -> new CourseStatus(
                                            studentId, course, status
                                    )
                            );

            courseStatus.setStatus(status);

            results.add(repository.save(courseStatus));
        }

        return results;
    }

    public CourseStatus getStatus(Long studentId, String course) {

        if (studentId == null || studentId <= 0) {
            throw new IllegalArgumentException(
                    "Student ID must be positive"
            );
        }

        if (course == null || course.isBlank()) {
            throw new IllegalArgumentException(
                    "Course cannot be empty"
            );
        }

        return repository.findByStudentIdAndCourse(
                        studentId,
                        course.trim().toUpperCase(Locale.ROOT)
                )
                .orElseThrow(
                        () -> new com.example.elearning.EnrollmentNotFoundException (
                                "No enrollment found for student "
                                        + studentId + " and course " + course
                        )
                );
    }
}
