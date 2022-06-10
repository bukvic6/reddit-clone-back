package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.ReactionDTO;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.model.Reaction;
import com.reddit.RedditClone.service.PostService;
import com.reddit.RedditClone.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.reddit.RedditClone.model.ReactionType.UPVOTE;

@RestController
@RequestMapping(value = "/api/votes")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @Autowired
    private PostService postService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ReactionDTO>reaction(@RequestBody ReactionDTO reactionDTO){
        if(reactionDTO.getPostId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Post post = postService.findOneById(reactionDTO.getPostId());
        if (post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(UPVOTE.equals(reactionDTO.getType())){
            post.setKarma(post.getKarma() + 1);
        } else {
            post.setKarma(post.getKarma() - 1);
        }
        postService.save(post);

        Reaction reaction = new Reaction();
        LocalDate lt = LocalDate.now();
        reaction.setTimestamp(lt);
        reaction.setType(reactionDTO.getType());
        reaction = reactionService.save(reaction);
        return new ResponseEntity<>(new ReactionDTO(reaction), HttpStatus.CREATED);
    }
}
