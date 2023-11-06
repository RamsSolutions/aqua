package com.aqua.repository;


import com.aqua.entity.AmberfieldReturningStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmberfieldReturningStudentRepository extends JpaRepository<AmberfieldReturningStudent, Long> {

    // Add a method to find a student by student number
    AmberfieldReturningStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    AmberfieldReturningStudent findByEmail(String email);

}