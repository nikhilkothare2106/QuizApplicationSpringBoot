package com.quiz.Quiz.Application.repo;

import com.quiz.Quiz.Application.entity.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    User findByEmailAndPassword(String email,String password);

    Optional<User> findByEmail(String email);
}
