package com.aqua.controller;

import com.aqua.entity.TaungStudent;
import com.aqua.service.TaungStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaungStudentController {

    private final TaungStudentService studentService;

    @Autowired
    public TaungStudentController(TaungStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/firstT")
    public String createStudentForm(Model model){
        TaungStudent taungStudent = new TaungStudent();
        model.addAttribute("taungStudent", taungStudent);
        return "bookT";
    }

    @PostMapping("/saveT")
    public String saveTaungStudent(@ModelAttribute TaungStudent student){
        studentService.saveTaungStudent(student);
        return "success_booked";
    }

}
