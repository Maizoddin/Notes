package com.example.Learn.controller;

import com.example.Learn.dto.StudentDTO;
import com.example.Learn.dto.StudentResponseDTO;
import com.example.Learn.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent = studentService.saveStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findStudentById(@PathVariable(name = "id") Long id) {
        StudentResponseDTO studentResponseDTO = studentService.findStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}
