package com.studentmanager.service;

import com.studentmanager.model.StudentDTO;
import com.studentmanager.model.StudentModel;
import com.studentmanager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> getStudentById(Long id) {
        return studentRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        StudentModel student = convertToEntity(studentDTO);
        StudentModel savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        StudentModel studentModel = studentRepository.findById(id).orElseThrow();
        studentModel.setFirstName(studentDTO.firstName());
        studentModel.setLastName(studentDTO.lastName());
        studentModel.setEmail(studentDTO.email());
        studentModel.setPhoneNumber(studentDTO.phoneNumber());
        studentModel.setDegree(studentDTO.degree());
        studentModel.setNationalCode(studentDTO.nationalCode());
        StudentModel updatedStudent = studentRepository.save(studentModel);
        return convertToDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentDTO convertToDTO(StudentModel student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getDegree(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getNationalCode()
        );
    }

    private StudentModel convertToEntity(StudentDTO studentDTO) {
        StudentModel studentModel = new StudentModel();
        studentModel.setFirstName(studentDTO.firstName());
        studentModel.setLastName(studentDTO.lastName());
        studentModel.setDegree(studentDTO.degree());
        studentModel.setNationalCode(studentDTO.nationalCode());
        studentModel.setPhoneNumber(studentDTO.phoneNumber());
        studentModel.setEmail(studentDTO.email());
        return studentModel;
    }
}
