package com.aqua.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "moahi_student")
public class MoahiStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "student_number")
    private String studentNo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNo;

    public MoahiStudent(String firstName, String lastName, String studentNo, String email, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNo = studentNo;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}
