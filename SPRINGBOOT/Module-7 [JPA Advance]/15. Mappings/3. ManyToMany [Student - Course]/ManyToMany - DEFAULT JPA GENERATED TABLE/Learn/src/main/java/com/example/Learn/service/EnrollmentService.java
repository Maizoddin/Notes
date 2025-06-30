package com.example.Learn.service;

import com.example.Learn.entity.Course;
import com.example.Learn.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
 private final StudentService studentService;
 private final CourseService courseService;
 public EnrollmentService(StudentService studentService, CourseService courseService){
     this.courseService = courseService;
     this.studentService = studentService;
 }

 @Transactional
 public void enroll(Long studentId, Long courseId){
     Student student = studentService.findStudentForEnrollment(studentId);
     Course course = courseService.findCourseForEnrollment(courseId);
     student.getCourses().add(course);
//     course.getStudents().add(student);
 }
}
