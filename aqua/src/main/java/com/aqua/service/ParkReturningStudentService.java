package com.aqua.service;



import com.aqua.entity.ParkReturningStudent;
import com.aqua.repository.ParkReturningStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkReturningStudentService {

    private final ParkReturningStudentRepository repository;

    @Autowired
    public ParkReturningStudentService(ParkReturningStudentRepository repository) {
        this.repository = repository;
    }



    public String saveParkReturningStudent(ParkReturningStudent student) {
        // Check if a student with the same student number or email already exists
        ParkReturningStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        ParkReturningStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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


    public Iterable<ParkReturningStudent> getAllParkReturningStudent(){
        return repository.findAll();
    }
}
