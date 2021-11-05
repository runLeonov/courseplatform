package com.example.courseplatform.controller;

import com.example.courseplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("")
public class MainController {
    @Autowired
    UserService userService;
    @RequestMapping("/main")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping("/validateasd")
    public String getTestValues(
            @RequestParam("testsSummary") Integer testsSummary,
            @RequestParam("lessonNumber") String lessonNumber
    ) {
        userService.setTestGrade(testsSummary, lessonNumber);
        return lessonNumber + ".html";
    }

}
