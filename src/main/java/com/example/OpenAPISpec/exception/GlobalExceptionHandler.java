package com.example.OpenAPISpec.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Global Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        // You can format the message(s) here nicely
        StringBuilder sb = new StringBuilder();
/*        e.getConstraintViolations().forEach(cv -> {
            sb.append(cv.getMessage()).append("; ");
        });*/
        sb.append(e.getMessage());
        return ResponseEntity.badRequest().body(sb.toString());
    }

    @ExceptionHandler(StudentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleStudentExists(StudentAlreadyExistsException e)
    {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(e.getMessage());
        return new ResponseEntity<>(stringBuffer.toString(),HttpStatus.BAD_REQUEST);
    }

    // Validation at DTO and Service class
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
