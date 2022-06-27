package com.reddit.RedditClone.service;

import com.reddit.RedditClone.dto.UserDTO;
import com.reddit.RedditClone.model.User;

public interface UserService {
    User createUser(UserDTO userDTO);

    User findByUsername(String username);
}
