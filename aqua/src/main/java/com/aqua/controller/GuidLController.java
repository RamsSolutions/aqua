package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuidLController {
    @GetMapping("/guidL")
    public String guidLPage() {
        return "guidL"; // Return the index HTML page
    }
}
