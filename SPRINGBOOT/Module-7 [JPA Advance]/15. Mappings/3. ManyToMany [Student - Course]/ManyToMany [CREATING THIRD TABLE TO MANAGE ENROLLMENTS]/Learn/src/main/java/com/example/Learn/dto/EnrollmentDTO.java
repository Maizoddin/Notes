package com.example.Learn.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EnrollmentDTO {
    private Long studentId;
    private Long courseId;
}
