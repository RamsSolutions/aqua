package com.aqua.controller;

import com.aqua.entity.ParkStudent;
import com.aqua.service.ParkStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ParkStudentController {

    private final ParkStudentService studentService;

    @Autowired
    public ParkStudentController(ParkStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/firstP")
    public String createStudentForm(Model model){
        ParkStudent parkStudent = new ParkStudent();
        model.addAttribute("parkStudent", parkStudent);
        return "bookP";
    }

    @PostMapping("/saveP")
    public String saveParkStudent(@ModelAttribute ParkStudent student){
        studentService.saveParkStudent(student);
        return "success_booked";
    }
}
