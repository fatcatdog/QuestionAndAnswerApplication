package com.jacob.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jacob.demo.model.Question;
import com.jacob.demo.service.QuestionService;

//this class uploads a bunch of dummy data into our application
@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private QuestionService questionService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Question q1 = new Question("What is 10 + 15 + 12?", 37);
		Question q2 = new Question("What is 1 + 5 + 2?", 8);
		Question q3 = new Question("What is 10 + 20 + 30?", 60);
		Question q4 = new Question("What is 100 + 1 + 3?", 104);

		questionService.save(q1);
		questionService.save(q2);
		questionService.save(q3);
		questionService.save(q4);
	}
}
