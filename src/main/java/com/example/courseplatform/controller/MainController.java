package com.example.courseplatform.controller;

import com.example.courseplatform.service.UserService;
import com.example.courseplatform.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("")
public class MainController {
    @Autowired
    UserService userService;
    @GetMapping("/main")
    public String getHomePage(HttpSession session) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", principal.getUsername());
        session.setAttribute("lesson10", userService.getTestList(principal.getUsername()));
        return "main.html";
    }

    @GetMapping("/validateasd")
    public String getTestValues(
            @RequestParam("testsSummary") Integer testsSummary,
            @RequestParam("lessonNumber") Integer lessonNumber,
            @RequestParam("nextLesson") String nextLesson
    ) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            userService.setTestGrade(username, testsSummary, lessonNumber);
        }
        return nextLesson + ".html";
    }

}
