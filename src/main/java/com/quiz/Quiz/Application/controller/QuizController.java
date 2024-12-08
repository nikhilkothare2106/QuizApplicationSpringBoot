package com.quiz.Quiz.Application.controller;

import com.quiz.Quiz.Application.entity.Question;
import com.quiz.Quiz.Application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuizController {
    @Autowired
    private QuizService quizService;


    @PostMapping("/save-question")
    @ResponseBody
    public List<Question> saveQuestion(@RequestBody  List<Question> question){
        return quizService.addQuestion(question);
    }

    @GetMapping("/quiz")
    public String quizPage(@RequestParam String topic,Model model){
        model.addAttribute("topic",topic);
        return "quiz";
    }

    @GetMapping("/get-questions")
    @ResponseBody
    public List<Question> getAllQuestions(@RequestParam String topic){
        try{
            return quizService.getQuestions(topic);
        }
        catch (Exception e){
            e.printStackTrace();
            return List.of();
        }

    }

    @GetMapping("/result")
    public String resultPage(@RequestParam int quizScore,
                        @RequestParam int totalQuestions,
                         Model model){
        model.addAttribute("quizScore",quizScore);
        model.addAttribute("totalQuestions",totalQuestions);
        return "result";
    }
}
