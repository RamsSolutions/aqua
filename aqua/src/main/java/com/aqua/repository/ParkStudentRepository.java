package com.aqua.repository;


import com.aqua.entity.ParkStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkStudentRepository extends JpaRepository<ParkStudent, Long> {

    // Add a method to find a student by student number
    ParkStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    ParkStudent findByEmail(String email);

}
