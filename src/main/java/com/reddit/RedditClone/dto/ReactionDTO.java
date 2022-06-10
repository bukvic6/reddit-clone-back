package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Reaction;
import com.reddit.RedditClone.model.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDTO {
    private ReactionType type;

    private Long postId;
    public ReactionDTO(Reaction reaction) {
        type = reaction.getType();
    }
}
