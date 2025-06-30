package com.example.Learn.mapper;


import com.example.Learn.dto.*;
import com.example.Learn.entity.Course;
import com.example.Learn.entity.Enrollment;
import com.example.Learn.entity.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentMapper {

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }

    public static Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setInstructor(courseDTO.getInstructor());
        return course;
    }

    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    public static CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle(course.getTitle());
        courseDTO.setInstructor(course.getInstructor());
        return courseDTO;
    }

    public static StudentResponseDTO toResponse(Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setCourses(toCourseDTOSet(student.getEnrollments()));
        return studentResponseDTO;
    }

    public static CourseResponseDTO toResponse(Course course) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setTitle(course.getTitle());
        courseResponseDTO.setInstructor(course.getInstructor());
        courseResponseDTO.setStudents(toStudentDTOSet(course.getEnrollments()));
        return courseResponseDTO;
    }

    public static Set<CourseDTO> toCourseDTOSet(Set<Enrollment> enrollments) {
        Set<CourseDTO> courses = new HashSet<>();
        for (Enrollment enrollment : enrollments) {
            courses.add(toDTO(enrollment.getCourse()));
        }
        return courses;
    }

    public static Set<StudentDTO> toStudentDTOSet(Set<Enrollment> enrollments) {
        Set<StudentDTO> students = new HashSet<>();
        for (Enrollment enrollment : enrollments) {
            students.add(toDTO(enrollment.getStudent()));
        }
        return students;
    }

    public static EnrollmentResponseDTO toResponse(Enrollment enrollment) {
        EnrollmentResponseDTO enrollmentResponseDTO = new EnrollmentResponseDTO();
        enrollmentResponseDTO.setStudent(toDTO(enrollment.getStudent()));
        enrollmentResponseDTO.setCourse(toDTO(enrollment.getCourse()));
        enrollmentResponseDTO.setEnrolledAt(enrollment.getEnrolledAt());
        return enrollmentResponseDTO;
    }
}
