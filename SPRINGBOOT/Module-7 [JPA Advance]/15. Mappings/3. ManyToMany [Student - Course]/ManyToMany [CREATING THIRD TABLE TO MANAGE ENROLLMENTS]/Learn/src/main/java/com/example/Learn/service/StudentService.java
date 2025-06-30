package com.example.Learn.service;

import com.example.Learn.dto.StudentDTO;
import com.example.Learn.dto.StudentResponseDTO;
import com.example.Learn.entity.Student;
import com.example.Learn.mapper.StudentMapper;
import com.example.Learn.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toDTO(savedStudent);
    }

    @Transactional
    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

    public StudentResponseDTO findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return StudentMapper.toResponse(student);
    }

    // Only Student
    public Student findStudent(Long id){
        return studentRepository.findById(id).orElseThrow();
    }
}
