package com.example.Learn.service;

import com.example.Learn.dto.CourseDTO;
import com.example.Learn.entity.Course;
import com.example.Learn.entity.Student;
import com.example.Learn.mapper.StudentMapper;
import com.example.Learn.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final StudentMapper mapper;

    public CourseService(CourseRepository courseRepository, StudentService studentService) {
        this.studentService = studentService;
        this.courseRepository = courseRepository;
        this.mapper = new StudentMapper();
    }

    @Transactional
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = mapper.toEntity(courseDTO);
        studentService.saveAllStudents(course.getStudents());
        return mapper.toDTO(course);
    }

    public CourseDTO findById(Long id){
        Course course = courseRepository.findById(id).orElseThrow();
        return mapper.toDTO(course);
    }

    public Course findCourseForEnrollment(Long id){
        return courseRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        Course course = courseRepository.findById(id).orElseThrow();
        for(Student student : course.getStudents()){
            student.getCourses().remove(course);
        }
        courseRepository.deleteById(id);
    }
}
