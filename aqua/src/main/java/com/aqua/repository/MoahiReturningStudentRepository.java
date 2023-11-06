package com.aqua.repository;


import com.aqua.entity.MoahiReturningStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoahiReturningStudentRepository extends JpaRepository<MoahiReturningStudent, Long> {

    // Add a method to find a student by student number
    MoahiReturningStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    MoahiReturningStudent findByEmail(String email);

}
