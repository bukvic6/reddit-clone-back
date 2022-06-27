package com.reddit.RedditClone.service;

import com.reddit.RedditClone.dto.ReactionDTO;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.model.Reaction;
import com.reddit.RedditClone.repository.PostRepository;
import com.reddit.RedditClone.repository.ReactionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.reddit.RedditClone.model.ReactionType.UPVOTE;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReactionService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReactionRepository reactionRepository;

    public Reaction save(Reaction reaction){
        try {
            return reactionRepository.save(reaction);
        }catch (IllegalArgumentException e){
            return null;
        }
    }
    public Reaction findByUserId(Long id){
        return reactionRepository.findByUserId(id);
    }
}
