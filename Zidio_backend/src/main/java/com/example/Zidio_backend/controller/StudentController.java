package com.example.Zidio_backend.controller;

import com.example.Zidio_backend.entity.Student;
import com.example.Zidio_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // For development only
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Register
    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.CREATED);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        Optional<Student> student = studentService.login(loginData.get("email"), loginData.get("password"));
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Update Profile
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateProfile(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateProfile(id, student));
    }
}
