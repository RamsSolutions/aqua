package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProfile {

    @GetMapping("/profile")
    public String myProfile() {
        return "app-profile";
    }


}
