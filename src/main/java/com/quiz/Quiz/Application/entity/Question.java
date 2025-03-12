package com.quiz.Quiz.Application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")  // Define MongoDB collection name
public class Question {

    @Id
    private String id;  // Changed from int to String for MongoDB compatibility

    private String questionText;
    private String correctAnswer;
    private String topic;
    private List<String> options;  // MongoDB natively supports lists


}
