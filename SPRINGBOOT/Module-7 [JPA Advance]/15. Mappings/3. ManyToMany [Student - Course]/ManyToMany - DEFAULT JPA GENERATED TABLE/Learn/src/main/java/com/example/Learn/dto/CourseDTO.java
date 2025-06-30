package com.example.Learn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "students")
@EqualsAndHashCode
public class CourseDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Instructor is required")
    private String instructor;

    private Set<StudentSimpleDTO> students;
}
