package com.reddit.RedditClone.dto;
import com.reddit.RedditClone.model.Post;
import lombok.Data;
import java.time.LocalDate;



public class PostDTO {
    private Long id;
    private String title;
    private String text;
    private String imagePath;
    private CommunityDTO community;

    public PostDTO() {
    }


    public PostDTO(Post post){
        id = post.getPostId();
        title = post.getTitle();
        text = post.getText();
        imagePath = post.getImagePath();
        community = new CommunityDTO(post.getCommunity());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public CommunityDTO getCommunity() {
        return community;
    }

    public void setCommunity(CommunityDTO community) {
        this.community = community;
    }
}

