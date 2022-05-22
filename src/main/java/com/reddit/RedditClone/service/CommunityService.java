package com.reddit.RedditClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reddit.RedditClone.dto.CommunityDTO;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.repository.CommunityRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CommunityService {
	
	@Autowired 
	private CommunityRepository communityRepository;
	
	
	public void save(CommunityDTO communityDTO) {
		Community save = communityRepository.save(mapCommunityDTO(communityDTO));
		communityDTO.setId(save.getId());
		return communityDTO
		
	}
	
	private void mapCommunityDTO(CommunityDTO communityDTO) {
		Community.Builder().name(communityDTO.getName())
		.description(communityDTO.getDescription()).build();
	}

}
