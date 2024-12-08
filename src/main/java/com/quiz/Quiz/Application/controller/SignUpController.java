package com.quiz.Quiz.Application.controller;

import com.quiz.Quiz.Application.entity.User;
import com.quiz.Quiz.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @Autowired
    private UserService userService;


    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // Renders signup.html
    }
    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user,
                         String confirmPassword,
                         Model model){

        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error","Passwords do not match");
            return "signup"; // Return to sign-up page with error
        }

        if (userService.createUser(user.getEmail(), user.getName(), user.getGender(), user.getPassword())) {
            model.addAttribute("success","Sucessfully Registered!");
            return "login"; // Redirect to login page after successful sign-up
        } else {
            model.addAttribute("error","User with this email already exists");
            return "signup"; // Return to sign-up page with error
        }
    }
}
