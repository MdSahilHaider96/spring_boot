package com.social.media.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @OneToOne(mappedBy = "socialUser", cascade ={CascadeType.REMOVE, CascadeType.PERSIST,CascadeType.MERGE})
    private SocialProfile socialProfile;
    @OneToMany(mappedBy = "socialUser")
    private List<Post> postList = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();

    public SocialUser() {
    }

    public SocialUser(int id, String description, SocialProfile socialProfile, List<Post> postList, Set<SocialGroup> groups) {
        this.id = id;
        this.description = description;
        this.socialProfile = socialProfile;
        this.postList = postList;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SocialProfile getSocialProfile() {
        return socialProfile;
    }

    public void setSocialProfile(SocialProfile socialProfile) {
        this.socialProfile = socialProfile;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Set<SocialGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<SocialGroup> groups) {
        this.groups = groups;
    }
}
