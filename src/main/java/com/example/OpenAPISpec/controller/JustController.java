package com.example.OpenAPISpec.controller;


import com.example.OpenAPISpec.dto.StudentsDto;
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
@RequestMapping("/student")@Validated
@Tag(
        name = "Student REST API's",
        description = "Student level API's"
)
public class JustController {

    @Autowired
    StudentService studentService;


public ResponseEntity<List<Student>> getAllStudents(){
     return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
}

//http://localhost:8080/swagger-ui/index.html#/
    @PostMapping("/{id}/entry")
public ResponseEntity<StudentsDto> saveStudent(@RequestBody StudentsDto dto){
    return new ResponseEntity<>(studentService.saveStudent(dto),HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Student> isStudentExists(@PathVariable long id){
    Optional<Student> student=studentService.getById(id);
    return new ResponseEntity<>(student.get(),HttpStatus.OK);
}

}
