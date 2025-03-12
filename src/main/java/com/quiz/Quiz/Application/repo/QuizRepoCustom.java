package com.quiz.Quiz.Application.repo;

import com.quiz.Quiz.Application.entity.Question;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@Repository
public class QuizRepoCustom {

    private final MongoTemplate mongoTemplate;

    public QuizRepoCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Question> findRandomlyByTopic(String topic, int limit) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("topic").is(topic)), // Filter by topic
                Aggregation.sample(limit) // Fetch 'limit' number of random questions
        );

        AggregationResults<Question> results = mongoTemplate.aggregate(aggregation, "questions", Question.class);
        System.out.println(results);
        return results.getMappedResults();
    }
}
