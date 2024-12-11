package com.project.quiz.service;

import java.util.List;
import com.project.quiz.model.Question;

public interface QuestionService {
	public List<Question> getByid(Long id);
	public Question save(Question question);
	public void deleteQuestion(Long id) throws Exception;
	public List<String> getCorrectAnswer(String question_text);
	public List<Question> getQuestions();
}
