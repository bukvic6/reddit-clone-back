package com.reddit.RedditClone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reddit.RedditClone.model.Community;
import org.springframework.data.jpa.repository.Query;


public interface CommunityRepository extends JpaRepository<Community, Long> {

    @Query("select c from Community c where c.id =?1")
     Community findOneById(Long communityId);
}
