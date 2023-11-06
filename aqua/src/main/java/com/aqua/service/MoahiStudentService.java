package com.aqua.service;


import com.aqua.entity.MoahiStudent;
import com.aqua.repository.MoahiStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoahiStudentService {

    private final MoahiStudentRepository repository;

    @Autowired
    public MoahiStudentService(MoahiStudentRepository repository) {
        this.repository = repository;
    }



    public String saveMoahiStudent(MoahiStudent student) {
        // Check if a student with the same student number or email already exists
        MoahiStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        MoahiStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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


    public Iterable<MoahiStudent> getAllMoahiStudents(){
        return repository.findAll();
    }

}
