package com.reddit.RedditClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reddit.RedditClone.dto.CommunityDTO;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.repository.CommunityRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CommunityService {

	@Autowired
	private CommunityRepository communityRepository;


	public Community save(Community community){
		try{
			return communityRepository.save(community);
		}catch (IllegalArgumentException e){
			return null;
		}
	}

	public List<Community> getAll(){
		return communityRepository.findAll();
	}

 }
