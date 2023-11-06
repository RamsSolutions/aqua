package com.aqua.controller;


import com.aqua.entity.MoahiReturningStudent;
import com.aqua.service.MoahiReturningStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoahiReturningStudentController {

    private final MoahiReturningStudentService returningStudentService;
    @Autowired
    public MoahiReturningStudentController(MoahiReturningStudentService returningStudentService) {
        this.returningStudentService = returningStudentService;
    }


    @GetMapping("/secondMR")
    public String createReturningStudentForm(Model model){
        MoahiReturningStudent moahiReturningStudent = new MoahiReturningStudent();
        model.addAttribute("moahiReturningStudent", moahiReturningStudent);
        return "bookRM";
    }

    @PostMapping("/saveRM")
    public String saveMoahiReturningStudent(@ModelAttribute MoahiReturningStudent student) {
        returningStudentService.saveMoahiReturningStudent(student);
        return "success_booked"; // Redirect back to the second HTML page
    }


}
