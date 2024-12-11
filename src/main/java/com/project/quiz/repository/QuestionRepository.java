package com.project.quiz.repository;

import com.project.quiz.model.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	public List<Question> findByid(Long id);

	public List<Question> findByQuestionText(String questionText);
}

