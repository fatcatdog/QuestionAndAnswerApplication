package com.jacob.demo.model;

import java.io.Serializable;

//this class is responsible for carrying the JWT that is returned to user
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}