package com.aqua.controller;


import com.aqua.entity.AmberfieldReturningStudent;
import com.aqua.service.AmberfieldReturningStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AmberfieldReturningStudentController {

    private final AmberfieldReturningStudentService returningStudentService;

    @Autowired
    public AmberfieldReturningStudentController(AmberfieldReturningStudentService returningStudentService) {
        this.returningStudentService = returningStudentService;
    }

    // Create REST endpoint for the second HTML file
//    @GetMapping("/second")
//    public String secondHtmlPage() {
//        return "secondHtmlPage"; // Return the appropriate Thymeleaf template
//    }

        @GetMapping("/second")
    public String createReturningStudentForm(Model model){
        AmberfieldReturningStudent amberfieldReturningStudent = new AmberfieldReturningStudent();
        model.addAttribute("amberfieldReturningStudent", amberfieldReturningStudent);
        return "bookRA";
    }

    // Create REST endpoint to handle form submission for AmberfieldReturningStudent
    @PostMapping("/saveR")
    public String saveAmberfieldReturningStudent(@ModelAttribute AmberfieldReturningStudent student) {
        returningStudentService.saveAmberfieldReturningStudent(student);
        return "success_booked"; // Redirect back to the second HTML page
    }
}
