package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BDController {

    @GetMapping("/BD")
    public String dBPage() {
        return "BD"; // Return the index HTML page
    }
}
