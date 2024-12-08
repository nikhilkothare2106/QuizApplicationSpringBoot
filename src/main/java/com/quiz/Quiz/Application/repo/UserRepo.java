package com.quiz.Quiz.Application.repo;

import com.quiz.Quiz.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email,String password);
}
