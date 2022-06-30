package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.CommunityDTO;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.model.User;
import com.reddit.RedditClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.reddit.RedditClone.service.CommunityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/community")
@AllArgsConstructor
@Slf4j
public class CommunityController {

	@Autowired
	private CommunityService communityService;

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<CommunityDTO> create(@RequestBody CommunityDTO communityDTO){
		Community community = new Community();
		LocalDate lt = LocalDate.now();
		community.setCreationDate(lt);
		community.setName(communityDTO.getName());
		community.setDescription(communityDTO.getDescription());
		User user = userService.findByUsername("jova");
		community.setUser(user);
		community = communityService.save(community);
		return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.CREATED);

	}
	@GetMapping
	public ResponseEntity<List<CommunityDTO>> getAll(){
		List<Community>communities = communityService.getAll();

		List<CommunityDTO> communityDTOS = new ArrayList<>();
		for (Community  c : communities){
			communityDTOS.add(new CommunityDTO(c));
		}
		return new ResponseEntity<>(communityDTOS, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CommunityDTO>getCommunity(@PathVariable Long id){
		Community community = communityService.findOneById(id);
		if (community == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);

	}
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<CommunityDTO> updateCommunity(@PathVariable Long id,@RequestBody CommunityDTO communityDTO){
		Community community = communityService.findOneById(id);
		if (community == null ){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		community.setDescription(communityDTO.getDescription());
		community.setName(communityDTO.getName());

		community = communityService.save(community);
		return new ResponseEntity<>(new CommunityDTO(community), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCommunity(@PathVariable Long id){
		Community community = communityService.findOneById(id);
		if(community != null){
			communityService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
}


