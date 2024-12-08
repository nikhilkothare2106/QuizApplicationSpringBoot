package com.quiz.Quiz.Application.repo;

import com.quiz.Quiz.Application.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT * FROM question WHERE topic = :topic ORDER BY RAND() limit 8", nativeQuery = true)
    List<Question> findRandomlyByTopic(@Param("topic") String topic);
}