package com.reddit.RedditClone.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static javax.persistence.FetchType.LAZY;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Community {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
	private String description;

    @OneToMany(mappedBy = "community",fetch = LAZY,  cascade = CascadeType.ALL)
	private Set<Post> posts = new HashSet<Post>();

	@Column(nullable = false)
    private LocalDate creationDate;
    private String suspendedReason;
}
