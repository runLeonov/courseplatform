package com.example.courseplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("")
public class MainController {

    @RequestMapping("/main")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping("/validateasd")
    public String getTestValues(
            @ModelAttribute Object obj
    ) {
        return "index.html";
    }

}
