package com.example.courseplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("")
public class MainController {

    @RequestMapping("/main")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping("/validateasd")
    public String getTestValues(
            @RequestParam("testsSummary") Integer testsSummary,
            @ModelAttribute Object obj
    ) {
        return "index.html";
    }

}
