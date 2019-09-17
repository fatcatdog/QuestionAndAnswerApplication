package com.jacob.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacob.demo.model.DAOUser;

//our User JPA repository 
@Repository
public interface UserRepository extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
}
