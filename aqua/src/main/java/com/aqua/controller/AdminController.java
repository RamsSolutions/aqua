package com.aqua.controller;

import com.aqua.entity.AmberfieldStudent;
import com.aqua.entity.AmberfieldReturningStudent;
import com.aqua.service.AmberfieldStudentService;
import com.aqua.service.AmberfieldReturningStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



    @Controller
    @RequestMapping("/admin")
    public class AdminController {
        private final AmberfieldStudentService studentService;
        private final AmberfieldReturningStudentService returningStudentService;


        @Autowired
        public AdminController(
                AmberfieldStudentService studentService,
                AmberfieldReturningStudentService returningStudentService) {
            this.studentService = studentService;
            this.returningStudentService = returningStudentService;
        }

        @GetMapping("/list-all-students")
        public String listAllStudents(Model model) {
            Iterable<AmberfieldStudent> students = studentService.getAllAmberfieldStudents();
            Iterable<AmberfieldReturningStudent> returningStudents = returningStudentService.getAllAmberfieldReturningStudents();

            model.addAttribute("amberfieldStudent", students);
            model.addAttribute("amberfieldReturningStudent", returningStudents);

            return "table-basic"; // Return the HTML page with the combined list
        }
    }


