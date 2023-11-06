package com.aqua.service;


import com.aqua.entity.AmberfieldReturningStudent;
import com.aqua.repository.AmberfieldReturningStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmberfieldReturningStudentService {

    private final AmberfieldReturningStudentRepository repository;

    @Autowired
    public AmberfieldReturningStudentService(AmberfieldReturningStudentRepository repository) {
        this.repository = repository;
    }



    public String saveAmberfieldReturningStudent(AmberfieldReturningStudent student) {
        // Check if a student with the same student number or email already exists
        AmberfieldReturningStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        AmberfieldReturningStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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


    public Iterable<AmberfieldReturningStudent> getAllAmberfieldReturningStudents() {
        return repository.findAll();
    }
}