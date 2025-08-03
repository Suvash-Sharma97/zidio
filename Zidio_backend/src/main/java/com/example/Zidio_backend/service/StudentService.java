package com.example.Zidio_backend.service;

import com.example.Zidio_backend.entity.Student;
import com.example.Zidio_backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> login(String email, String password) {
        return studentRepository.findByEmail(email)
                .filter(s -> s.getPassword().equals(password)); // Replace with hashed check in production
    }

    public Student updateProfile(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFullName(updatedStudent.getFullName());
        student.setContact(updatedStudent.getContact());
        student.setAbout(updatedStudent.getAbout());
        student.setResumePath(updatedStudent.getResumePath());
        return studentRepository.save(student);
    }
}
