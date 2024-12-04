package com.quiz.Quiz.Application.controller;

import com.quiz.Quiz.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public List<String> logIn(@RequestParam String email,
                              @RequestParam String password){

        return userService.getUser(email, password);
    }
}