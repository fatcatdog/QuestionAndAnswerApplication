package com.jacob.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//our question pojo
@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String ask;
	
	@Column
	private int answer;

	public Question(int id, String ask, int answer) {
		super();
		this.id = id;
		this.ask = ask;
		this.answer = answer;
	}
	
	public Question(String ask, int answer) {
		super();
		this.ask = ask;
		this.answer = answer;
	}
	
	public Question() {}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
}