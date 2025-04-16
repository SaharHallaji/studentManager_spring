package com.studentmanager.controller;

import com.studentmanager.model.StudentDTO;
import com.studentmanager.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/get-all")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/get-byId/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        Optional<StudentDTO> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/save")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        try {
            StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
