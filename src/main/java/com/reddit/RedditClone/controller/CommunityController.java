package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.CommunityDTO;
import com.reddit.RedditClone.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.reddit.RedditClone.service.CommunityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/community")
@AllArgsConstructor
@Slf4j
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	@PostMapping("/create")
	public ResponseEntity<CommunityDTO> create(@RequestBody CommunityDTO communityDTO){
		Community community = new Community();
		LocalDate lt = LocalDate.now();
		community.setCreationDate(lt);
		community.setName(communityDTO.getName());
		community.setDescription(communityDTO.getDescription());
		community = communityService.save(community);
		return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.CREATED);

	}
	@GetMapping
	public ResponseEntity<List<Community>> getAll(){
		return new ResponseEntity<>(communityService.getAll(), HttpStatus.OK);
	}

	
}


