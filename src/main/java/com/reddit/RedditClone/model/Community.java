package com.reddit.RedditClone.model;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@Entity
public class Community {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	private Set<Post> posts = new HashSet<Post>();

	@Column(nullable = false)
    private LocalDate creationDate;
    private String suspendedReason;

	public void addPost(Post post) {
		posts.add(post);
		post.setCommunity(this);

	}
	public Community(){}


}
