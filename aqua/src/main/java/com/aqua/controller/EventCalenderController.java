package com.aqua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventCalenderController {

    @GetMapping("/event-calender")
    public String eventCalender() {
        return "app-event-calender";
    }


}
