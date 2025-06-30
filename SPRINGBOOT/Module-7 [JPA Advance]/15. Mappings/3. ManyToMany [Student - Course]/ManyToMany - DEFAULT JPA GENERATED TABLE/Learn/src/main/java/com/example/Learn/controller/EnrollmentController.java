package com.example.Learn.controller;

import com.example.Learn.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enrollments")
    public ResponseEntity<String> enroll(@RequestParam(name = "studentId", required = true) Long studentId, @RequestParam(name = "courseId", required = true) Long courseId) {
        enrollmentService.enroll(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Enrolled");
    }
}
