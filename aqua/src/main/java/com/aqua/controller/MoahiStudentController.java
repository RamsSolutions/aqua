package com.aqua.controller;


import com.aqua.entity.MoahiStudent;
import com.aqua.service.MoahiStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoahiStudentController {

    private final MoahiStudentService studentService;

    public MoahiStudentController(MoahiStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/firstM")
    public String createStudentForm(Model model){
        MoahiStudent moahiStudent = new MoahiStudent();
        model.addAttribute("moahiStudent", moahiStudent);
        return "bookM";
    }

    @PostMapping("/saveM")
    public String saveMoahiStudent(@ModelAttribute MoahiStudent student){
        studentService.saveMoahiStudent(student);
        return "success_booked";
    }

}
