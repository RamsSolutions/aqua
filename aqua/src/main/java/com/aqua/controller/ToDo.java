package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDo {

    @GetMapping("/todo")
    public String toDo() {
        return "uc-todo-list"; // Return the HTML page for the admin home
    }


}
