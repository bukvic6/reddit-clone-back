package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select c from Post c where c.postId =?1")
         Post findOneById(Long postId);

    @Query("select c from Post c where c.community.id =?1")

    List<Post> findAllByCommunity(Long id);
}
