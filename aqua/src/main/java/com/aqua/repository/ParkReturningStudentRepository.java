package com.aqua.repository;


import com.aqua.entity.ParkReturningStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkReturningStudentRepository extends JpaRepository<ParkReturningStudent, Long> {

    // Add a method to find a student by student number
    ParkReturningStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    ParkReturningStudent findByEmail(String email);

}
