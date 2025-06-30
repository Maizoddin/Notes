package com.example.Learn.repository;

import com.example.Learn.entity.Enrollment;
import com.example.Learn.entity.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
}
