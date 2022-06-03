package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.PostDTO;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.service.CommunityService;
import com.reddit.RedditClone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommunityService communityService;

    @PostMapping("/createPost")
    public ResponseEntity<PostDTO>createPost(@RequestBody PostDTO postDTO){
        if(postDTO.getCommunity() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Community community = communityService.findOneById(postDTO.getCommunity().getId());

        if(community == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setText(postDTO.getText());
        post.setImagePath(postDTO.getImagePath());
        LocalDate lt = LocalDate.now();
        post.setCreationDate(lt);
        post.setCommunity(community);

        post = postService.save(post);
        return new ResponseEntity<>(new PostDTO(post), HttpStatus.CREATED);
    }

}
