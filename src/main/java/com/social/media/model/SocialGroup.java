package com.social.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private Set<SocialUser> socialUsers= new HashSet<>();

    public SocialGroup() {
    }

    public SocialGroup(int id, Set<SocialUser> socialUsers) {
        this.id = id;
        this.socialUsers = socialUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<SocialUser> getSocialUsers() {
        return socialUsers;
    }

    public void setSocialUsers(Set<SocialUser> socialUsers) {
        this.socialUsers = socialUsers;
    }
}
