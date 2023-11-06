package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContD {
    @GetMapping("/ContD")
    public String contDPage() {
        return "ContD"; // Return the index HTML page
    }
}
