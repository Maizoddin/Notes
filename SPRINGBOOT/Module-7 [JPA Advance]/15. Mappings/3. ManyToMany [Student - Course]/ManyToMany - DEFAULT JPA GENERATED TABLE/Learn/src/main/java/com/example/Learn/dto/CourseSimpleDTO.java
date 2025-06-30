package com.example.Learn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CourseSimpleDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Instructor is required")
    private String instructor;
}
