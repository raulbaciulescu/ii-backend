package com.university.iibackend.repository;

import com.university.iibackend.model.Quiz;
import com.university.iibackend.model.QuizAnswer;
import com.university.iibackend.model.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Integer> {
    List<QuizAnswer> findByUser(User user);

    List<QuizAnswer> findByUserAndQuiz(User user, Quiz quiz);
}
