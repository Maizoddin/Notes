package com.example.Learn.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnrollmentId implements Serializable {

    private Long studentId;
    private Long courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof EnrollmentId)) {
            return false;
        } else {
            EnrollmentId that = (EnrollmentId) o;
            return Objects.equals(this.studentId, that.studentId) &&
                    Objects.equals(this.courseId, that.courseId);
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(studentId, courseId);
    }
}
