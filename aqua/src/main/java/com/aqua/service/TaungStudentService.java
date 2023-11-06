package com.aqua.service;


import com.aqua.entity.TaungStudent;
import com.aqua.repository.TaungStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaungStudentService {

    private final TaungStudentRepository repository;

    @Autowired
    public TaungStudentService(TaungStudentRepository repository) {
        this.repository = repository;
    }



    public String saveTaungStudent(TaungStudent student) {
        // Check if a student with the same student number or email already exists
        TaungStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        TaungStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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

    public Iterable<TaungStudent> getAllTaungStudents(){
        return repository.findAll();
    }

}
