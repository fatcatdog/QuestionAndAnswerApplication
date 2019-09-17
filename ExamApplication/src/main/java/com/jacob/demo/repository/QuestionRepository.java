package com.jacob.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jacob.demo.model.Question;

//our Question JPA repository
//called by QuestionService
@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
