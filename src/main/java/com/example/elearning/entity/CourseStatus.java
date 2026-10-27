
        package com.example.elearning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        name = "COURSE_STATUS",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_student_course",
                        columnNames = {"STUDENT_ID", "COURSE"}
                )
        }
)
public class CourseStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STUDENT_ID", nullable = false)
    private Long studentId;

    @Column(name = "COURSE", nullable = false, length = 100)
    private String course;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    // Default constructor required by JPA
    public CourseStatus() {
    }

    // Constructor for creating a course status
    public CourseStatus(Long studentId, String course, String status) {
        this.studentId = studentId;
        this.course = course;
        this.status = status;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseStatus{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", course='" + course + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
