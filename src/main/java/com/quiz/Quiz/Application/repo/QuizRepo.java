package com.quiz.Quiz.Application.repo;

import com.quiz.Quiz.Application.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends MongoRepository<Question, String> {

    // Find all questions by topic
    List<Question> findByTopic(String topic);


}
