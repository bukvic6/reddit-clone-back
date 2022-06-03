package com.reddit.RedditClone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
	private String email;
    private String username;
    private String password;

}
