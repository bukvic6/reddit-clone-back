package com.reddit.RedditClone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.RedditClone.dto.RegisterRequest;
import com.reddit.RedditClone.service.AuthService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<String>signup(@RequestBody RegisterRequest registerRequest) {

		authService.signup(registerRequest);
		return new ResponseEntity<>("User registration successful", HttpStatus.OK);
	}

}
