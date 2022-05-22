package com.reddit.RedditClone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reddit.RedditClone.model.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    Optional<Community> findByName(String subredditName);
}
