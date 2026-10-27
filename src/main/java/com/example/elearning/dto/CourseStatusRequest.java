package com.example.elearning.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseStatusRequest {

    @NotBlank(message = "Entries cannot be empty")
    private String entries;

    public CourseStatusRequest() {
    }

    public CourseStatusRequest(String entries) {
        this.entries = entries;
    }

    public String getEntries() {
        return entries;
    }

    public void setEntries(String entries) {
        this.entries = entries;
    }
}