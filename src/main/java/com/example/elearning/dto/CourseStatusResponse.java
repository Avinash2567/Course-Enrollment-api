package com.example.elearning.dto;

public class CourseStatusResponse {

    private Long studentId;
    private String course;
    private String status;

    public CourseStatusResponse() {
    }

    public CourseStatusResponse(
            Long studentId,
            String course,
            String status
    ) {
        this.studentId = studentId;
        this.course = course;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }
}
