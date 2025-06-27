package com.example.OpenAPISpec.entity;

import java.time.LocalDateTime;
// NEW (Spring Boot 3.x)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Student entity representing a student record.
 */
@Entity
public class Student {
    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String className;
    private long phoneNum;

}
