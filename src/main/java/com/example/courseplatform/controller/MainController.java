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

@Controller("")
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/main", "/*"})
    public String getHomePage(
            @RequestParam( value = "lessonNumber", required = false) Integer lessonNumber,
            HttpSession session, Model model) {
        User user = getUserFromSession();
        session.setAttribute("userDB", user);
        session.setAttribute("lesson10", userService.getTestList(user.getUsername()));
        session.setAttribute("thisLessonGrade", userService.getExistLessonsGrads(user.getUsername()));
        return "main.html";
    }

    @GetMapping("/validate")
    public String getTestValues(
            @RequestParam("testsSummary") Integer testsSummary,
            @RequestParam("lessonNumber") Integer lessonNumber,
            @RequestParam("nextLesson") String nextLesson,
            Model model, HttpSession session
    ) {
        User user = getUserFromSession();
        session.setAttribute("userDB", user);
        session.setAttribute("thisLessonGrade", userService.getExistLessonsGrads(user.getUsername()));
//        model.addAttribute("thisLessonGrade", user.getLessonTestByLessonNumber(lessonNumber));
        userService.setTestGrade(user.getUsername(), testsSummary, lessonNumber);
        return nextLesson + ".html";
    }

    private User getUserFromSession() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return  (User) principal;
        }
        return null;
    }

}
