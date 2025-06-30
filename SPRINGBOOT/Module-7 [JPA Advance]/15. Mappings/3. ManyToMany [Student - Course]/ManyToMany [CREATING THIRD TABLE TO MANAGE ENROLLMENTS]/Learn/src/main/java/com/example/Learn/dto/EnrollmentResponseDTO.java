package com.example.Learn.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnrollmentResponseDTO {
    private StudentDTO student;
    private CourseDTO course;
    private LocalDateTime enrolledAt;
}
