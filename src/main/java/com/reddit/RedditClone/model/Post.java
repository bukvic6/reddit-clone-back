package com.reddit.RedditClone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String text;
    private LocalDate creationDate;
    private String imagePath;

    public Post(){}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "community_Id")
    private Community community;


    public Community getCommunity(){
        return community;
    }
    public void setCommunity(Community community) {
        this.community = community;
    }
}
