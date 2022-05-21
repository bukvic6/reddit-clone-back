package com.reddit.RedditClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddit.RedditClone.dto.RegisterRequest;
import com.reddit.RedditClone.model.User;
import com.reddit.RedditClone.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user = new User();

	       user.setUsername(registerRequest.getUsername());
	        user.setEmail(registerRequest.getEmail());
	        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		
	        userRepository.save(user);	
	}

}
