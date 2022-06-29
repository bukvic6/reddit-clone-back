package com.reddit.RedditClone.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Admin extends User{
    public Admin() {
    }

    public Admin(Long Id, String username, String password, String email, String avatar, String description, String displayName, LocalDate creationDate) {
        super(Id, username, password, email, avatar, description, displayName, creationDate);
    }
}
