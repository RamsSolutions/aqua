package com.aqua.repository;


import com.aqua.entity.TaungReturningStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaungReturningStudentRepository extends JpaRepository<TaungReturningStudent, Long> {

    // Add a method to find a student by student number
    TaungReturningStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    TaungReturningStudent findByEmail(String email);

}
