package com.studentmanager.model;

import com.studentmanager.enums.EducationEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;


@Setter
@Getter
@Entity
@Table(name = "students",catalog = "student_db")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EducationEnum degree;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(unique = true, name = "national_code", nullable = false)
    private String nationalCode;

    @CreationTimestamp()
    @Column(name = "created_on")
    private Instant createdOn;

    @UpdateTimestamp()
    @Column(name = "updated_on")
    private Instant updatedOn;

    public StudentModel() {}

}
