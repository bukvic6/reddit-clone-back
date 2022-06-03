package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Community;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommunityDTO {
	private Long id;
	private String name;
	private String description;
	private LocalDate creationDate;
	private String suspendedReason;


	public CommunityDTO(Community community) {
		this(community.getId(), community.getName(),community.getDescription(), community.getCreationDate(),community.getSuspendedReason());
	}

	public CommunityDTO(Long id, String name, String description, LocalDate creationDate, String suspendedReason) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.suspendedReason = suspendedReason;
	}
}

