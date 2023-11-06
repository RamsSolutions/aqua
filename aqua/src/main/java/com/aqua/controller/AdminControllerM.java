package com.aqua.controller;


import com.aqua.entity.MoahiReturningStudent;
import com.aqua.entity.MoahiStudent;
import com.aqua.service.MoahiReturningStudentService;
import com.aqua.service.MoahiStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/adminM")
public class AdminControllerM {

    private final MoahiStudentService studentService;
    private final MoahiReturningStudentService returningStudentService;

    public AdminControllerM(MoahiStudentService studentService, MoahiReturningStudentService returningStudentService) {
        this.studentService = studentService;
        this.returningStudentService = returningStudentService;
    }

    @GetMapping("/list-all-studentsM")
    public String listAllStudents(Model model){
        Iterable<MoahiStudent> students = studentService.getAllMoahiStudents();
        Iterable<MoahiReturningStudent> returningStudents = returningStudentService.getAllMoahiReturningStudents();

        model.addAttribute("moahiStudent", students);
        model.addAttribute("moahiReturningStudent", returningStudents);
        return "table-basicM";
    }

}
