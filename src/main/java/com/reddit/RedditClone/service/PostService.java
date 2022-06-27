package com.reddit.RedditClone.service;

import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Post findOneById(Long postId) {
        return  postRepository.findOneById(postId);
    }

    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> findAllByCommunity(Long id) {
        return postRepository.findAllByCommunity(id);
    }
}
