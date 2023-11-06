package com.aqua.repository;


import com.aqua.entity.AmberfieldStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmberfieldStudentRepository extends JpaRepository<AmberfieldStudent, Long> {

    // Add a method to find a student by student number
    AmberfieldStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    AmberfieldStudent findByEmail(String email);

}

