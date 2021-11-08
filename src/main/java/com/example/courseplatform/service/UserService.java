package com.example.courseplatform.service;

import com.example.courseplatform.service.entity.User;
import com.example.courseplatform.service.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public User setTestGrade(String username, Integer test, Integer lesson) {
        User user = (User) loadUserByUsername(username);
        user.setLessonTestByLessonNumber(test, lesson);
        return userRepository.save(user);
    }

    public List<Integer> getTestList(String username) {
        User user = userRepository.findByUsername(username);
        List<Integer> testsGrads = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            if (Objects.isNull(user.getLessonTestByLessonNumber(i)))
                testsGrads.add(0);
            else
                testsGrads.add(user.getLessonTestByLessonNumber(i));
        }
        return testsGrads;
    }

    public  Map<Integer, Boolean> getExistLessonsGrads(String username) {
        User user = userRepository.findByUsername(username);
        Map<Integer, Boolean> integerBooleanMap = new HashMap<>();
        for (int i = 1; i <= 15; i++) {
            if (Objects.isNull(user.getLessonTestByLessonNumber(i)))
                integerBooleanMap.put(0, false);
            else if (Objects.nonNull(user.getLessonTestByLessonNumber(i)) && user.getLessonTestByLessonNumber(i) >= 7)
                integerBooleanMap.put(user.getLessonTestByLessonNumber(i), true);
            else
                integerBooleanMap.put(user.getLessonTestByLessonNumber(i), false);
        }
        return integerBooleanMap;
    }
    public List<User> allUsers() {
        return userRepository.findAll();
    }
}