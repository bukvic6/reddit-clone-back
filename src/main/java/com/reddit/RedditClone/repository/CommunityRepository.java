package com.reddit.RedditClone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reddit.RedditClone.model.Community;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    Optional<Community> findByName(String subredditName);

    @Query("select c from Community c join fetch c.posts p where c.id = ?1")
     Community findOneById(Long id);
}
