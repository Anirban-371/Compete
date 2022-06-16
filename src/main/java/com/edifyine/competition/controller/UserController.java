package com.edifyine.competition.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edifyine.competition.pojo.QuestionAnswer;
import com.edifyine.competition.pojo.AuthenticationRequest;
import com.edifyine.competition.pojo.AuthenticationResponse;
import com.edifyine.competition.pojo.CompeteUser;
import com.edifyine.competition.service.QuestionAnswerService;
import com.edifyine.competition.service.UserService;
import com.edifyine.competition.serviceImpl.CompeteUserDetailsService;
import com.edifyine.competition.utils.JwtUtil;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CompeteUserDetailsService competeUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException ex) {
			new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
		}
		final UserDetails userDetails = competeUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Void> saveUser(@RequestBody CompeteUser user){
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompeteUser> getUserDetails(@PathVariable("id") String id){
		return new ResponseEntity<>(userService.getUserDetails(id),HttpStatus.OK);
				
	}
	
	@PutMapping
	public ResponseEntity<Void> updateUser(@RequestBody CompeteUser user){
		userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@QueryParam("id") long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
				
	}
}
