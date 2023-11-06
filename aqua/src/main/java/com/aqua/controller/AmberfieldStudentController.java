package com.aqua.controller;


import com.aqua.entity.AmberfieldStudent;
import com.aqua.service.AmberfieldStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class AmberfieldStudentController {

    private final AmberfieldStudentService studentService;

    @Autowired
    public AmberfieldStudentController(AmberfieldStudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/first")
    public String createStudentForm(Model model){
        AmberfieldStudent amberfieldStudent = new AmberfieldStudent();
        model.addAttribute("amberfieldStudent", amberfieldStudent);
        return "bookA";
    }

    // Create REST endpoint to handle form submission for AmberfieldStudent
    @PostMapping("/save")
    public String saveAmberfieldStudent(@ModelAttribute AmberfieldStudent student) {
        studentService.saveAmberfieldStudent(student);
        return "success_booked"; // Redirect back to the first HTML page
    }
}
