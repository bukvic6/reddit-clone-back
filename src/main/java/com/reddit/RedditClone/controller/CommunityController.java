package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.RedditClone.dto.CommunityDTO;
import com.reddit.RedditClone.service.CommunityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/community")
@AllArgsConstructor
@Slf4j
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	@PostMapping("/create")
	public ResponseEntity<Community> create(@RequestBody Community community){
		community.setCreationDate("datum");
		Community createdCommunity = communityService.save(community);

		if(createdCommunity == null){
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(createdCommunity, HttpStatus.OK);
	}

}


