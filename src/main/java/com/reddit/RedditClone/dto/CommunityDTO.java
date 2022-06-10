package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Community;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


public class CommunityDTO {
	private Long id;
	private String name;

	private String description;


	public CommunityDTO(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public CommunityDTO(Community community) {
		this(community.getId(), community.getName(), community.getDescription());
	}

	public CommunityDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;

	}
}

