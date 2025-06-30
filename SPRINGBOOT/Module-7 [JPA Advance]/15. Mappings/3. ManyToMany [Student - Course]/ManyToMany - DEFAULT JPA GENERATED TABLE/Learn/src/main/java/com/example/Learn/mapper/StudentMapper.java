package com.example.Learn.mapper;

import com.example.Learn.dto.CourseDTO;
import com.example.Learn.dto.CourseSimpleDTO;
import com.example.Learn.dto.StudentDTO;
import com.example.Learn.dto.StudentSimpleDTO;
import com.example.Learn.entity.Course;
import com.example.Learn.entity.Student;

import java.util.Set;
import java.util.stream.Collectors;

public class StudentMapper {

    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setCourses(simpleCourseListToCourseEntityList(studentDTO.getCourses(), student));
        return student;
    }

    public StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setCourses(courseEntityListToSimpleCourseList(student.getCourses()));
        return studentDTO;
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setInstructor(courseDTO.getInstructor());
        course.setStudents(simpleStudentListToStudentEntityList(courseDTO.getStudents(), course));
        return course;
    }

    public CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle(course.getTitle());
        courseDTO.setInstructor(course.getInstructor());
        courseDTO.setStudents(studentEntityListToSimpleStudentList(course.getStudents()));
        return courseDTO;
    }

    public Set<StudentSimpleDTO> studentEntityListToSimpleStudentList(Set<Student> students) {
        return students.stream().map((student) -> {
            StudentSimpleDTO studentSimpleDTO = new StudentSimpleDTO();
            studentSimpleDTO.setName(student.getName());
            studentSimpleDTO.setEmail(student.getEmail());
            return studentSimpleDTO;
        }).collect(Collectors.toSet());
    }

    public Set<Student> simpleStudentListToStudentEntityList(Set<StudentSimpleDTO> studentDTOList, Course course) {
        return studentDTOList.stream().map((studentDTO) -> {
            Student student = new Student();
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.getCourses().add(course);
            return student;
        }).collect(Collectors.toSet());
    }

    public Set<CourseSimpleDTO> courseEntityListToSimpleCourseList(Set<Course> courses) {
        return courses.stream().map((course) -> {
            CourseSimpleDTO courseSimpleDTO = new CourseSimpleDTO();
            courseSimpleDTO.setTitle(course.getTitle());
            courseSimpleDTO.setInstructor(course.getInstructor());
            return courseSimpleDTO;
        }).collect(Collectors.toSet());
    }

    public Set<Course> simpleCourseListToCourseEntityList(Set<CourseSimpleDTO> coursesDTOList, Student student) {
        return coursesDTOList.stream().map((courseDTO) -> {
            Course course = new Course();
            course.setTitle(courseDTO.getTitle());
            course.setInstructor(courseDTO.getInstructor());
            course.getStudents().add(student);
            return course;
        }).collect(Collectors.toSet());
    }

}
