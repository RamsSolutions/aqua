package com.aqua.service;


import com.aqua.entity.AmberfieldStudent;
import com.aqua.repository.AmberfieldStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmberfieldStudentService {

    private final AmberfieldStudentRepository repository;

    @Autowired
    public AmberfieldStudentService(AmberfieldStudentRepository repository) {
        this.repository = repository;
    }



    public String saveAmberfieldStudent(AmberfieldStudent student) {
        // Check if a student with the same student number or email already exists
        AmberfieldStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        AmberfieldStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

        if (existingStudentByStudentNo != null) {
            return "Student with the same Student Number already exists.";
        }

        if (existingStudentByEmail != null) {
            return "Student with the same Email already exists.";
        }

        // If no existing student found, save the new student
        repository.save(student);
        return "Student information saved successfully!";
    }


    public Iterable<AmberfieldStudent> getAllAmberfieldStudents() {
        return repository.findAll();
    }
}