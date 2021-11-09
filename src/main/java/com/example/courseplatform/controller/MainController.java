package com.example.courseplatform.controller;

import com.example.courseplatform.service.UserService;
import com.example.courseplatform.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller("")
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/main", "/"})
    public String getHomePage(HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            User user = (User) principal;
            session.setAttribute("userDB", user);
            session.setAttribute("thisLessonGrade", userService.getExistLessonsGrads(user.getUsername()));
            session.setAttribute("lesson10", Collections.singletonList(userService.getExistLessonsGrads(user.getUsername()).keySet()));
        }
        return "main.html";
    }

    @GetMapping("/validate")
    public String getTestValues(
            @RequestParam("testsSummary") Integer testsSummary,
            @RequestParam("lessonNumber") Integer lessonNumber,
            @RequestParam("nextLesson") String nextLesson,
            HttpSession session
    ) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            User user = (User) principal;
            session.setAttribute("userDB", user);
            session.setAttribute("thisLessonGrade", userService.getExistLessonsGrads(user.getUsername()));
            userService.setTestGrade(user.getUsername(), testsSummary, lessonNumber);
        }
        return nextLesson + ".html";
    }

}
