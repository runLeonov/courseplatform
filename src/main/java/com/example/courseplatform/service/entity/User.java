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

    public void setLessonTestByLessonNumber(Integer test, Integer lesson) {
        switch (lesson) {
            case 1:
                setLesson1(test);
                break;
            case 2:
                setLesson2(test);
                break;
            case 3:
                setLesson3(test);
                break;
            case 4:
                setLesson4(test);
                break;
            case 5:
                setLesson5(test);
                break;
            case 6:
                setLesson6(test);
                break;
            case 7:
                setLesson7(test);
                break;
            case 8:
                setLesson8(test);
                break;
            case 9:
                setLesson9(test);
                break;
            case 10:
                setLesson10(test);
                break;
            case 11:
                setLesson11(test);
                break;
            case 12:
                setLesson12(test);
                break;
            case 13:
                setLesson13(test);
                break;
            case 14:
                setLesson14(test);
                break;
            case 15:
                setLesson15(test);
                break;
        }
    }

    public Integer getLessonTestByLessonNumber(Integer lesson) {
        switch (lesson) {
            case 1:
                return getLesson1() == null ? 0 : getLesson1();
            case 2:
                return getLesson2() == null ? 0 : getLesson2();
            case 3:
                return getLesson3() == null ? 0 : getLesson3();
            case 4:
                return getLesson4() == null ? 0 : getLesson4();
            case 5:
                return getLesson5() == null ? 0 : getLesson5();
            case 6:
                return getLesson6() == null ? 0 : getLesson6();
            case 7:
                return getLesson7() == null ? 0 : getLesson7();
            case 8:
                return getLesson8() == null ? 0 : getLesson8();
            case 9:
                return getLesson9() == null ? 0 : getLesson9();
            case 10:
                return getLesson10() == null ? 0 : getLesson10();
            case 11:
                return getLesson11() == null ? 0 : getLesson11();
            case 12:
                return getLesson12() == null ? 0 : getLesson12();
            case 13:
                return getLesson13() == null ? 0 : getLesson13();
            case 14:
                return getLesson14() == null ? 0 : getLesson14();
            case 15:
                return getLesson15() == null ? 0 : getLesson15();
            default:
                return 0;
        }
    }
}
