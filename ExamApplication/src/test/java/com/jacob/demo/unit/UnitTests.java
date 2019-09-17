package com.jacob.demo.unit;

import static org.junit.Assert.assertEquals;

import javax.persistence.Column;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jacob.demo.model.DAOUser;
import com.jacob.demo.model.Question;

public class UnitTests {

    @Test
    public void checkingIfOurQuestionIsFormingCorrectlyTest() {
    	Question ourQuestion = new Question(1, "We have a new question?", 7);
    
        assertEquals(ourQuestion.getId(), 1);
        assertEquals(ourQuestion.getAsk(), "We have a new question?");
        assertEquals(ourQuestion.getAnswer(), 7);
    }
    
    @Test
    public void checkingIfOurDAOUserIsFormingCorrectlyTest() {
    	DAOUser ourUser = new DAOUser(1L, "ourDummyUsername", "aBadPassword");
    
        assertEquals(ourUser.getPassword(), "aBadPassword");
        assertEquals(ourUser.getUsername(), "ourDummyUsername");
    }
}
