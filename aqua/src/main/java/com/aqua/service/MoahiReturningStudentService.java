package com.aqua.service;



import com.aqua.entity.MoahiReturningStudent;
import com.aqua.repository.MoahiReturningStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoahiReturningStudentService {

    private final MoahiReturningStudentRepository repository;
    @Autowired
    public MoahiReturningStudentService(MoahiReturningStudentRepository repository) {
        this.repository = repository;
    }

    public String saveMoahiReturningStudent(MoahiReturningStudent student) {
        // Check if a student with the same student number or email already exists
        MoahiReturningStudent existingStudentByStudentNo = repository.findByStudentNo(student.getStudentNo());
        MoahiReturningStudent existingStudentByEmail = repository.findByEmail(student.getEmail());

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

    public Iterable<MoahiReturningStudent> getAllMoahiReturningStudents() {
        return repository.findAll();
    }

}
