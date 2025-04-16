package com.studentmanager.model;

import com.studentmanager.enums.EducationEnum;

public record StudentDTO(Long studentId,
                         String firstName,
                         String lastName,
                         EducationEnum degree,
                         String email,
                         String phoneNumber,
                         String nationalCode
) {}
