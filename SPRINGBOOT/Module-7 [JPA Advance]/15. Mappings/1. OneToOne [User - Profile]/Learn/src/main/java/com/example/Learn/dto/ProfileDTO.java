package com.example.Learn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileDTO {
    @NotBlank(message = "bio is required")
    private String bio;
}
