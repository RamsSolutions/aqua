package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProspectorsController {
    @GetMapping("/prospectors")
    public String prospectorsPage() {
        return "prospectors"; // Return the index HTML page
    }
}
