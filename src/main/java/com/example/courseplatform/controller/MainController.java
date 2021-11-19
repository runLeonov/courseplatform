package com.example.courseplatform.controller;

import com.example.courseplatform.service.UserService;
import com.example.courseplatform.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Objects;

@Controller("")
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/les1", "/"})
    public String getHomePage(HttpSession session) {
        User user = getUserFromSession();

        session.setAttribute("userDB", user);
        session.setAttribute("lesson10", userService.getTestList(user.getUsername()));
        session.setAttribute("thisLessonGrade", userService.getExistLessonsGrads(user.getUsername()));

        return "les1.html";
    }

    @GetMapping("/validate")
    public String getTestValues(
            @RequestParam("testsSummary") Integer testsSummary,
            @RequestParam("lessonNumber") Integer lessonNumber,
            @RequestParam("nextLesson") String nextLesson,
            HttpSession session
    ) {
        User user = getUserFromSession();
        if (user.getLessonTestByLessonNumber(lessonNumber) == 0)
            userService.setTestGrade(user, testsSummary, lessonNumber);
        session.setAttribute("userDB", user);
        session.setAttribute("lesson10", userService.getTestList(user.getUsername()));
        session.setAttribute("thisLessonGrade", userService.getExistLessonsGrads(user.getUsername()));

        return nextLesson + ".html";
    }

    @GetMapping("/lesson")
    public String getTestValues(
            @RequestParam("goToLesson") Integer goToLesson,
            ModelMap modelMap,
            HttpSession session
    ) {
        User user = getUserFromSession();

        if ((goToLesson - 1) != 0 && user.getLessonTestByLessonNumber(goToLesson - 1) < 7) {
            modelMap.addAttribute("cannotAccessLesson", "Ви не можете переглянути цей урок, так як не завершили попередній");
            return null;
        }
        return "les" + goToLesson + ".html";
    }

    private User getUserFromSession() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();
        if (principal instanceof UserDetails) {
            user = (User) principal;
        }
        return user;
    }

}
