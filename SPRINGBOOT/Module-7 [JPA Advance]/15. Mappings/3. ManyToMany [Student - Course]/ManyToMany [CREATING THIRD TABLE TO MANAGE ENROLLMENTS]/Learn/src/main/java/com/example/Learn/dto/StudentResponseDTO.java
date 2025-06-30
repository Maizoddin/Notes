package com.example.Learn.dto;

import java.util.Set;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class StudentResponseDTO extends StudentDTO{
    private Set<CourseDTO> courses;
}
