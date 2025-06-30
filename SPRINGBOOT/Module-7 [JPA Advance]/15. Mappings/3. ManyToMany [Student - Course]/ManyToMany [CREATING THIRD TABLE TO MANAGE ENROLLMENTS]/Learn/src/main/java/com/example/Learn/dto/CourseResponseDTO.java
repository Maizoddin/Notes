package com.example.Learn.dto;

import lombok.*;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class CourseResponseDTO extends CourseDTO{
    private Set<StudentDTO> students;
}
