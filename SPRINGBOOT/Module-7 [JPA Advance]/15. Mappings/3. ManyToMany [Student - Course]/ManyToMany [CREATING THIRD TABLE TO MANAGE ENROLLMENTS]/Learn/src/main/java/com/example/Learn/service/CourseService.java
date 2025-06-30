package com.example.Learn.service;

import com.example.Learn.dto.CourseDTO;
import com.example.Learn.dto.CourseResponseDTO;
import com.example.Learn.entity.Course;
import com.example.Learn.mapper.StudentMapper;
import com.example.Learn.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = StudentMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return StudentMapper.toDTO(savedCourse);
    }

    @Transactional
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseResponseDTO findCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        return StudentMapper.toResponse(course);
    }

    // Only Course
    public Course findCourse(Long id){
        return courseRepository.findById(id).orElseThrow();
    }
}
