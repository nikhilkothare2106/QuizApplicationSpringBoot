package com.quiz.Quiz.Application.controller;

import com.quiz.Quiz.Application.entity.Question;
import com.quiz.Quiz.Application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/save-question")
    public List<Question> saveQuestion(@RequestBody  List<Question> question){
        return quizService.addQuestion(question);
    }

    @GetMapping("/get-questions")
    public List<Question> getAllQuestions(@RequestParam String topic){
        return quizService.getQuestions(topic);
    }
}
