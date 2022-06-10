package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ReactionRepository extends JpaRepository<Reaction, Long> {

}
