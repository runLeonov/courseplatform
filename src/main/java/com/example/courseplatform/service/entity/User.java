package com.example.courseplatform.service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Integer lesson1;
    private Integer lesson2;
    private Integer lesson3;
    private Integer lesson4;
    private Integer lesson5;
    private Integer lesson6;
    private Integer lesson7;
    private Integer lesson8;
    private Integer lesson9;
    private Integer lesson10;
    private Integer lesson11;
    private Integer lesson12;
    private Integer lesson13;
    private Integer lesson14;
    private Integer lesson15;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setLessonTestByLessonNumber(Integer test, String lesson) {
        if (lesson.equals("index")) setLesson1(test);
        if (lesson.equals("les2")) setLesson2(test);
        if (lesson.equals("les3")) setLesson3(test);
        if (lesson.equals("les4")) setLesson4(test);
        if (lesson.equals("les5")) setLesson5(test);
        if (lesson.equals("les6")) setLesson6(test);
        if (lesson.equals("les7")) setLesson7(test);
        if (lesson.equals("les8")) setLesson8(test);
        if (lesson.equals("les9")) setLesson9(test);
        if (lesson.equals("les10")) setLesson10(test);
        if (lesson.equals("les11")) setLesson11(test);
        if (lesson.equals("les12")) setLesson12(test);
        if (lesson.equals("les13")) setLesson13(test);
        if (lesson.equals("les14")) setLesson14(test);
        if (lesson.equals("les15")) setLesson15(test);
    }
}
