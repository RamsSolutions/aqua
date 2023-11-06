package com.aqua.service;


import com.aqua.entity.TaungReturningStudent;
import com.aqua.repository.TaungReturningStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaungReturningStudentService {

    private final TaungReturningStudentRepository repository;

    @Autowired
    public TaungReturningStudentService(TaungReturningStudentRepository repository) {
        this.repository = repository;
    }

    public String saveTaungReturningStudent(TaungReturningStudent student) {
        // Check if a student with the same student number or email already exists
        TaungReturningStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        TaungReturningStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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

    public Iterable<TaungReturningStudent> getAllTaungReturningStudents(){
        return repository.findAll();
    }

}
