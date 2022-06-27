package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.model.Reaction;
import com.reddit.RedditClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    @Query("select r from Reaction r where r.post.postId=?1 and r.user.Id=?2")
     public Reaction findByUserId(Long postId, Long id);
}
