package com.reddit.RedditClone.controller;

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
	
    @PostMapping
    public ResponseEntity<CommunityDTO> createSubreddit(@RequestBody CommunityDTO communityDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(communityService.save(communityDTO));
    }
    }
