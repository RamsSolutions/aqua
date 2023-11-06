package com.aqua.controller;

import com.aqua.entity.ParkReturningStudent;
import com.aqua.entity.ParkStudent;
import com.aqua.service.ParkReturningStudentService;
import com.aqua.service.ParkStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminP")
public class AdminControllerP {

    private final ParkStudentService studentService;
    private final ParkReturningStudentService returningStudentService;

    @Autowired
    public AdminControllerP(ParkStudentService studentService, ParkReturningStudentService returningStudentService) {
        this.studentService = studentService;
        this.returningStudentService = returningStudentService;
    }

    @GetMapping("/list-all-studentsP")
    public String listAllStudents(Model model){
        Iterable<ParkStudent> students = studentService.getAllParkStudents();
        Iterable<ParkReturningStudent> returningStudents = returningStudentService.getAllParkReturningStudent();

        model.addAttribute("parkStudent", students);
        model.addAttribute("parkReturningStudent", returningStudents);
        return "table-basicP";
    }
}
