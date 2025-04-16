package com.studentmanager.repository;

import com.studentmanager.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {}