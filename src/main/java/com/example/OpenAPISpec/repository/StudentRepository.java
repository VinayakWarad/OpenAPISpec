package com.example.OpenAPISpec.repository;

import com.example.OpenAPISpec.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

   Optional<Student> findByName(String name);
}
