package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAController {

    @GetMapping("/adminHome")
    public String adminHome() {
        return "index"; // Return the HTML page for the admin home
    }


}
