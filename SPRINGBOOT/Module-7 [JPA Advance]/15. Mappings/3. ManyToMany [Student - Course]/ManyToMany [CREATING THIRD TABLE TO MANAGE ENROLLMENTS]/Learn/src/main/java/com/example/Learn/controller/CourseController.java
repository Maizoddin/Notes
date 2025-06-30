package com.example.Learn.controller;

import com.example.Learn.dto.CourseDTO;
import com.example.Learn.dto.CourseResponseDTO;
import com.example.Learn.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.saveCourse(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> findCourseById(@PathVariable(name = "id") Long id) {
        CourseResponseDTO courseResponseDTO = courseService.findCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(courseResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(name = "id") Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}
