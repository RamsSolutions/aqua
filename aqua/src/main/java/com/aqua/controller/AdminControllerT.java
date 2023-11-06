package com.aqua.controller;

import com.aqua.entity.TaungReturningStudent;
import com.aqua.entity.TaungStudent;
import com.aqua.service.TaungReturningStudentService;
import com.aqua.service.TaungStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/adminT")
public class AdminControllerT {

    private final TaungStudentService studentService;
    private final TaungReturningStudentService returningStudentService;
    @Autowired
    public AdminControllerT(TaungStudentService studentService, TaungReturningStudentService returningStudentService) {
        this.studentService = studentService;
        this.returningStudentService = returningStudentService;
    }
    @GetMapping("/list-all-studentsT")
    public String listAllStudents(Model model){
        Iterable<TaungStudent> students = studentService.getAllTaungStudents();
        Iterable<TaungReturningStudent> returningStudents = returningStudentService.getAllTaungReturningStudents();

        model.addAttribute("taungStudent", students);
        model.addAttribute("taungReturningStudent", returningStudents);
        return "table-basicT";
    }
}
