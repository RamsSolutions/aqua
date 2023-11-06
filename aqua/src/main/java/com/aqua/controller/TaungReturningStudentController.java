package com.aqua.controller;

import com.aqua.entity.TaungReturningStudent;
import com.aqua.service.TaungReturningStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaungReturningStudentController {

    private final TaungReturningStudentService returningStudentService;

    @Autowired
    public TaungReturningStudentController(TaungReturningStudentService returningStudentService) {
        this.returningStudentService = returningStudentService;
    }


    @GetMapping("/secondTR")
    public String createReturningStudentForm(Model model){
        TaungReturningStudent taungReturningStudent = new TaungReturningStudent();
        model.addAttribute("taungReturningStudent", taungReturningStudent);
        return "bookRT";
    }

    @PostMapping("/saveRT")
    public String saveTaungReturningStudent(@ModelAttribute TaungReturningStudent student){
        returningStudentService.saveTaungReturningStudent(student);
        return "success_booked";
    }

}
