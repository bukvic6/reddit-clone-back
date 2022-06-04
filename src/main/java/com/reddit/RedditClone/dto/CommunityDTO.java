package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Community;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


public class CommunityDTO {
	private Long id;
	private String name;

	private String description;

	private LocalDate creationDate;
	private String suspendedReason;

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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getSuspendedReason() {
		return suspendedReason;
	}

	public void setSuspendedReason(String suspendedReason) {
		this.suspendedReason = suspendedReason;
	}


	public CommunityDTO(Community community) {
		this(community.getId(), community.getName(), community.getDescription(), community.getSuspendedReason(),community.getCreationDate());
	}

	public CommunityDTO(Long id, String name, String description, String suspendedReason, LocalDate creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.suspendedReason = suspendedReason;
		this.creationDate = creationDate;

	}
}

