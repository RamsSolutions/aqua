package com.aqua.controller;

import com.aqua.entity.ParkReturningStudent;
import com.aqua.service.ParkReturningStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParkReturningStudentController {

    private final ParkReturningStudentService returningStudentService;

    @Autowired
    public ParkReturningStudentController(ParkReturningStudentService returningStudentService) {
        this.returningStudentService = returningStudentService;
    }

    @GetMapping("/secondPR")
    public String createReturningStudentForm(Model model){
        ParkReturningStudent parkReturningStudent= new ParkReturningStudent();
        model.addAttribute("parkReturningStudent", parkReturningStudent);
        return "bookRP";
    }

    @PostMapping("/savePR")
    public String saveParkReturningStudent(@ModelAttribute ParkReturningStudent student){
        returningStudentService.saveParkReturningStudent(student);
        return "success_booked";
    }
}
