package com.example.courseplatform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("loginPage")
    public String getLoginPage(){
        return "login.html";
    }
}
