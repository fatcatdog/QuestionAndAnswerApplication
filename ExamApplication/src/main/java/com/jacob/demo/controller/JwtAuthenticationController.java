package com.jacob.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jacob.demo.config.JwtTokenUtil;
import com.jacob.demo.model.JwtRequest;
import com.jacob.demo.model.JwtResponse;
import com.jacob.demo.model.UserDTO;
import com.jacob.demo.service.JwtUserDetailsService;


//this controller provides the endpoints for validating JWT tokens, and saving users and supplying new JWT token
@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		try {
			userDetailsService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			final String token = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new JwtResponse(token));	
		} catch(Exception e) {
			System.out.println("JwtAuthenticationController createAuthenticationToken error: " + e);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		
		try {
			if(userDetailsService.checkIfUsernameAvailable(user.getUsername())) {
				return ResponseEntity.ok(userDetailsService.save(user));
			} else {
	    		return new ResponseEntity<>("Username taken", HttpStatus.BAD_REQUEST); 
			}
		}catch(Exception e) {
			System.out.println("JwtAuthenticationController saveUser error: " + e);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}

}