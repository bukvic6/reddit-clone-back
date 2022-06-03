package com.reddit.RedditClone.dto;
import com.reddit.RedditClone.model.Post;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String text;
    private LocalDate creationDate;
    private String imagePath;
    private CommunityDTO community;


    public PostDTO(Post post){
        id = post.getPostId();
        title = post.getTitle();
        text = post.getText();
        creationDate = post.getCreationDate();
        community = new CommunityDTO(post.getCommunity());

    }


}

