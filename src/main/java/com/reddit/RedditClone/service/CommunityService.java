package com.reddit.RedditClone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.repository.CommunityRepository;


import java.util.List;

@Service
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

	public Community findOneById(Long id){
		return communityRepository.findOneById(id);
	}


    //public Community findOneById(Long communityId) {
	//	return communityRepository.findOneById(communityId);
	//}
}
