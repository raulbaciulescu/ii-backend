package com.university.iibackend.repository;

import com.university.iibackend.model.QuizAnswer;
import com.university.iibackend.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Integer> {
    List<QuizAnswer> findByUser(User user);
}
