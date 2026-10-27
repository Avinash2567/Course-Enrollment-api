package com.example.elearning.controller;

import com.example.elearning.dto.CourseStatusRequest;
import com.example.elearning.dto.CourseStatusResponse;
import com.example.elearning.entity.CourseStatus;
import com.example.elearning.service.CourseStatusService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-status")
public class CourseStatusController {

    private final CourseStatusService service;

    public CourseStatusController(CourseStatusService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<List<CourseStatusResponse>> processEnrollments(
            @Valid @RequestBody CourseStatusRequest request
    ) {
        List<CourseStatus> results =
                service.processEnrollments(request.getEntries());

        List<CourseStatusResponse> response = results.stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{studentId}/{course}")
    public ResponseEntity<CourseStatusResponse> getStatus(
            @PathVariable Long studentId,
            @PathVariable String course
    ) {
        CourseStatus result = service.getStatus(studentId, course);

        return ResponseEntity.ok(toResponse(result));
    }

    private CourseStatusResponse toResponse(CourseStatus entity) {
        return new CourseStatusResponse(
                entity.getStudentId(),
                entity.getCourse(),
                entity.getStatus()
        );
    }
}