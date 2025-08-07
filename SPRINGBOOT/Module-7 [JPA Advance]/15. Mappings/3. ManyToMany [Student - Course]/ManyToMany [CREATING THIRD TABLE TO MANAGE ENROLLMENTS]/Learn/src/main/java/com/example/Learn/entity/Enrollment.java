
package com.example.Learn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id = new EnrollmentId();

    @Column(name = "enrolled_at")
    private LocalDateTime enrolledAt;

    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @MapsId("courseId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment(Student student, Course course){
        this.student = student;
        this.course = course;
        this.id = new EnrollmentId(student.getId(), course.getId());
        this.setEnrolledAt(LocalDateTime.now());
    }

}
