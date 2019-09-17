package com.jacob.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//our app's user object
@Entity
@Table(name = "appuser")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String username;
	
	@Column
	@JsonIgnore
	private String password;

	public DAOUser() {}
	
	public DAOUser(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}