package com.example.OpenAPISpec.service;

import com.example.OpenAPISpec.entity.Student;
import com.example.OpenAPISpec.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Student operations.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> getAll() { return repo.findAll(); }
    public Optional<Student> getById(Long id) { return repo.findById(id); }

}
