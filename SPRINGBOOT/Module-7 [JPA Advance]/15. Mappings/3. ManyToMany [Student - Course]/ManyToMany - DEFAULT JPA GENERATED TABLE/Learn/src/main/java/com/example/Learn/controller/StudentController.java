package com.example.Learn.controller;

import com.example.Learn.dto.StudentDTO;
import com.example.Learn.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> saveStudent(@Valid @RequestBody StudentDTO studentDTO){
        StudentDTO savedStudent = studentService.saveStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable(name = "id") Long id){
        StudentDTO studentDTO = studentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentDTO);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
    }
}
