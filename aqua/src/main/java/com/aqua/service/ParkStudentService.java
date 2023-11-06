package com.aqua.service;


import com.aqua.entity.ParkStudent;
import com.aqua.repository.ParkStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkStudentService {

    private final ParkStudentRepository repository;

    @Autowired
    public ParkStudentService(ParkStudentRepository repository) {
        this.repository = repository;
    }



    public String saveParkStudent(ParkStudent student) {
        // Check if a student with the same student number or email already exists
        ParkStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        ParkStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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

    public Iterable<ParkStudent> getAllParkStudents(){
        return repository.findAll();
    }

}
