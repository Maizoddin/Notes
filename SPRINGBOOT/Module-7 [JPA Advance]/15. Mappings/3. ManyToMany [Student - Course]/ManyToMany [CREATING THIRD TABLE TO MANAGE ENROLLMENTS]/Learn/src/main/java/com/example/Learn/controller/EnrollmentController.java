package com.example.Learn.controller;

import com.example.Learn.dto.EnrollmentResponseDTO;
import com.example.Learn.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<EnrollmentResponseDTO> getEnrollment(
            @RequestParam(name = "studentId") Long studentId,
            @RequestParam(name = "courseId") Long courseId) {
        EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.findEnrollmentById(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentResponseDTO);
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> enroll(
            @RequestParam(name = "studentId") Long studentId,
            @RequestParam(name = "courseId") Long courseId) {
        EnrollmentResponseDTO savedEnrollment = enrollmentService.enroll(studentId, courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
    }

    @DeleteMapping
    public ResponseEntity<String> unEnroll(
            @RequestParam(name = "studentId") Long studentId,
            @RequestParam(name = "courseId") Long courseId) {
        enrollmentService.unenroll(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Unenrolled Successfully");
    }
}
