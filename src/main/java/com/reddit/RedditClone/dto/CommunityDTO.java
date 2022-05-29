package com.reddit.RedditClone.dto;

import lombok.Builder;

@Builder
public class CommunityDTO {
	private Long id;
	private String name;
	private String communityName;
	private String description;
}
