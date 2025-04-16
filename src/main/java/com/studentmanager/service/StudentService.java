package com.studentmanager.service;

import com.studentmanager.model.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentDTO saveStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    Optional<StudentDTO> getStudentById(Long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}
