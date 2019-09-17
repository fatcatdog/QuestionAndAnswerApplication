package com.jacob.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jacob.demo.model.Question;
import com.jacob.demo.repository.QuestionRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//this service provides mostly standard CRUD operations 
//please reference the checkIfQuestionAnsweredCorrectly method to see the logic involved in confirming if a user supplied answer is correct or not
@Service
public class QuestionService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	QuestionRepository questionRepository;
	
	public void save(Question question) {
	    logger.info("QuestionService save");
	    logger.info("Question: " + question);
	    questionRepository.save(question);
	}
	
	public Optional<Question> getQuestion(int id) {
		logger.info("QuestionService getQuestion");
	    logger.info("Question id: " + id);
	    return questionRepository.findById(id);
	}
	
	public Iterable<Question> getAllQuestions(){
	    logger.info("QuestionService getAllQuestions");
		return questionRepository.findAll();
	}
	
	//this method checks if user supplied answer matches the corresponding question.id's answer 
	public int checkIfQuestionAnsweredCorrectly(Question question) {
		Question ourQuestionFromDB;
		
		Optional<Question> ourOptionalQuestionFromDB = questionRepository.findById((int)question.getId());
		
		if(ourOptionalQuestionFromDB.isPresent()) {
			ourQuestionFromDB = ourOptionalQuestionFromDB.get();
		} else {
			//3 will represent error fetching user input
			return 3;
		}
		
		if(ourQuestionFromDB.getAnswer() == question.getAnswer()) {
			//1 will represent correct answer
			return 1;
		} else {
			//2 will representing incorrect answer
			return 2;
		}
	}
	
	public void deleteQuestion(Question question) {
		try {
			questionRepository.delete(question);
		    logger.info("Question deleteQuestion: " + question);
		} catch(Exception e) {
		    logger.info("Question deleteQuestion: " + question);
		}
	}
	
}
