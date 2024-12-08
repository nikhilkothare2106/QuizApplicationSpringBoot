package com.quiz.Quiz.Application.controller;

import com.quiz.Quiz.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showSignupForm() {
        return "login"; // Renders signup.html
    }
    @PostMapping("/login")
    public String logIn(@RequestParam String email,
                              @RequestParam String password,
                              Model model){


        List<String> user = userService.getUser(email, password);
        if(user != null){
            model.addAttribute("email",user.get(0));
            model.addAttribute("name",user.get(1));
            return "main";
        }else{
            model.addAttribute("error","Wrong email or Password !");
            return "login";
        }
    }
}