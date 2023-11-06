package com.aqua.repository;


import com.aqua.entity.TaungStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaungStudentRepository extends JpaRepository<TaungStudent, Long> {

    // Add a method to find a student by student number
    TaungStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    TaungStudent findByEmail(String email);


}
