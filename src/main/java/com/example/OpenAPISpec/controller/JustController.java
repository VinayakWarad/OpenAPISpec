package com.example.OpenAPISpec.controller;


import com.example.OpenAPISpec.entity.Student;
import com.example.OpenAPISpec.repository.StudentRepository;
import com.example.OpenAPISpec.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@Validated
@Tag(
        name = "Student REST API's",
        description = "Student level API's"
)
public class JustController {
    @Value("${student.class}")
    private String studentclass;

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

@GetMapping("/")
public ResponseEntity<List<Student>> getAllStudents(){
     return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
}

@GetMapping("/{name}")
public ResponseEntity<Student> getAllStudentById(@PathVariable long id){
    Optional<Student> student=studentService.getById(id);
    return new ResponseEntity<>(student.get(),HttpStatus.OK);
}

}
