package com.quiz.Quiz.Application.controller;

import com.quiz.Quiz.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestParam String email,
                         @RequestParam String name,
                         @RequestParam String gender,
                         @RequestParam String password,
                         @RequestParam String confirmPassword){

        if (!password.equals(confirmPassword)) {
            return "redirect:signup.html?error=Passwords do not match"; // Return to sign-up page with error
        }

        if (userService.createUser(email, name, gender, password)) {
            return "redirect:login.html?success=Sucessfully Registered!"; // Redirect to login page after successful sign-up
        } else {

            return "redirect:signup.html?error=User with this email already exists"; // Return to sign-up page with error
        }
    }
}
