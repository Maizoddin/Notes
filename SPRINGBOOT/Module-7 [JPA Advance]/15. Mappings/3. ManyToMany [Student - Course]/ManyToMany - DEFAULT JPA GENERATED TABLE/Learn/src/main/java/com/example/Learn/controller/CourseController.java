package com.example.Learn.controller;
import com.example.Learn.dto.CourseDTO;
import com.example.Learn.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody @Valid CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.saveCourse(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable(name = "id") Long id) {
        CourseDTO courseDTO = courseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(courseDTO);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
        courseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }
}
