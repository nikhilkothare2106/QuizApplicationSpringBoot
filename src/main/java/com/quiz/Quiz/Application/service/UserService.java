package com.quiz.Quiz.Application.service;

import com.quiz.Quiz.Application.entity.User;
import com.quiz.Quiz.Application.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public boolean createUser(String email,String name,String gender,String password){
        if(userRepo.findByEmail(email) != null){//user already registred
            return false;
        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setGender(gender);
        user.setPassword(password);
        userRepo.save(user);
        return true;
    }

    public List<String> getUser(String email, String password){

        User user = userRepo.findByEmail(email);
        if(user == null){
            return null;
        }

        return Arrays.asList(user.getEmail(),user.getName());
    }
}
