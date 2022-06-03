package com.reddit.RedditClone.service;

import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
