package com.project.quiz.controller;
import com.project.quiz.model.Question;

import com.project.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class QuetionController {
	
		@Autowired
		private QuestionService questionService;
		 
		@GetMapping("/get")
	    public List<Question> getAllQuestions() {
	        return questionService.getQuestions();
	    }
	 
	    @PostMapping("/save")
	    public Map<String, Object> saveQuestion(@RequestBody Question question) {
	        Map<String, Object> response = new HashMap<>();
	        Question savedQuestion = questionService.save(question); // Save question

	        if (savedQuestion != null) {
	            response.put("message", "Question saved successfully");
	            response.put("status", HttpStatus.OK);
	        } else {
	            response.put("message", "Failed to save question");
	            response.put("status", HttpStatus.BAD_REQUEST);
	        }
	        response.put("timeStamp", new Date());
	        return response;
	    }

	    @GetMapping("/getquestions/{id}")
	    public List<Question> getQuestionById(@PathVariable Long id) {
	        return questionService.getByid(id);
	    }
	    
	    @DeleteMapping("/remove/{id}")
	    public Map<String,Object> deleteQuestion(@PathVariable Long id){
	    	Map<String,Object> response= new HashMap<>();
	    	try {
	    		questionService.deleteQuestion(id);
	    		response.put("message", "Question Deleted successfully");
	    		response.put("message", HttpStatus.OK);
	    	}catch (Exception e) {
				response.put("message", "Failed saved question");
				response.put("message", HttpStatus.BAD_REQUEST);
			}
	    	response.put("timeStamp", new Date());
			return response;
	    }
	    
	    @GetMapping("/getcorrectanswer/{question_text}")
	    public List<String> checkQuestionExist(@PathVariable String question_text){
			return questionService.getCorrectAnswer(question_text);
	    	
	    }
   
}

