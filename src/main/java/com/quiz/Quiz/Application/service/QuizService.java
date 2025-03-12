package com.quiz.Quiz.Application.service;

import com.quiz.Quiz.Application.entity.Question;
import com.quiz.Quiz.Application.repo.QuizRepo;
import com.quiz.Quiz.Application.repo.QuizRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuizRepoCustom quizRepoCustom;

    public List<Question> getQuestions(String topic){
        return quizRepoCustom.findRandomlyByTopic(topic,5);
    }

    @Transactional
    public List<Question> addQuestion(List<Question> question){
        return quizRepo.saveAll(question);
    }


}
