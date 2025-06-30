package com.example.Learn.service;

import com.example.Learn.dto.EnrollmentDTO;
import com.example.Learn.dto.EnrollmentResponseDTO;
import com.example.Learn.entity.Course;
import com.example.Learn.entity.Enrollment;
import com.example.Learn.entity.EnrollmentId;
import com.example.Learn.entity.Student;
import com.example.Learn.mapper.StudentMapper;
import com.example.Learn.repository.EnrollmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Transactional
    public EnrollmentResponseDTO enroll(Long studentId, Long courseId) {
        Student student = studentService.findStudent(studentId);
        Course course = courseService.findCourse(courseId);
        Enrollment enrollment = new Enrollment(student, course);
        student.addEnrollment(enrollment);
        course.addEnrollment(enrollment);
//        Automatically save happens because enrollment will get managed by persistence context and gets scheduled for persist due to student.addEnrollment() and it's happening because of cascade so no need to save again
        return StudentMapper.toResponse(enrollment);
    }

    @Transactional
    public void unenroll(Long studentId, Long courseId){
        EnrollmentId enrollmentId = new EnrollmentId(studentId, courseId);
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow();
        enrollment.getStudent().removeEnrollment(enrollment);
        enrollment.getCourse().removeEnrollment(enrollment);
        enrollmentRepository.deleteById(enrollmentId);
    }

    public EnrollmentResponseDTO findEnrollmentById(Long studentId, Long courseId){
        EnrollmentId enrollmentId = new EnrollmentId(studentId, courseId);
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow();
        return StudentMapper.toResponse(enrollment);
    }

}
