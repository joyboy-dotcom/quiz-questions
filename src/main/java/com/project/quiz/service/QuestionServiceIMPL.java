package com.project.quiz.service;



import com.project.quiz.model.Question;

import com.project.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceIMPL implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Override
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getByid(Long id) {
		return questionRepository.findByid(id);
	}
	
	@Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

	@Override
	public void deleteQuestion(Long id) throws Exception{
		try {
	        if (questionRepository.existsById(id)) {
	            questionRepository.deleteById(id); 
	        } else {
	            throw new Exception("User not found with ID: " + id);
	        }
	    } catch (Exception e) {
	        throw new Exception("Error deleting user: " + e.getMessage());
	    }
		
	}

	@Override
	public List<String> getCorrectAnswer(String question_text) {
		List<Question> questionText = questionRepository.findByQuestionText(question_text);
		List<String> correctAnswer = questionText.stream().map(Question::getCorrectAnswer).collect(Collectors.toList());
		return correctAnswer;
	}

	
	
    
}

