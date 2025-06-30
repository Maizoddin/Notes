package com.example.Learn.service;

import com.example.Learn.dto.StudentDTO;
import com.example.Learn.entity.Student;
import com.example.Learn.mapper.StudentMapper;
import com.example.Learn.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.mapper =  new StudentMapper();
    }

    @Transactional
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = mapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return mapper.toDTO(savedStudent);
    }

    @Transactional
    public void saveAllStudents(Set<Student> students){
        studentRepository.saveAll(students);
    }

    public StudentDTO findById(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        return mapper.toDTO(student);
    }

    public Student findStudentForEnrollment(Long id){
        return studentRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
}
