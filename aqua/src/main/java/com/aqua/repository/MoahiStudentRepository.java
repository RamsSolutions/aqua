package com.aqua.repository;



import com.aqua.entity.MoahiStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoahiStudentRepository extends JpaRepository<MoahiStudent, Long> {

    // Add a method to find a student by student number
    MoahiStudent findByStudentNo(String studentNo);

    // Add a method to find a student by email
    MoahiStudent findByEmail(String email);

}
