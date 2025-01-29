package com.social.media.configuration;

import com.social.media.model.Post;
import com.social.media.model.SocialGroup;
import com.social.media.model.SocialProfile;
import com.social.media.model.SocialUser;
import com.social.media.repository.PostRepo;
import com.social.media.repository.SocialGroupRepo;
import com.social.media.repository.SocialProfileRepo;
import com.social.media.repository.SocialUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataIntialzier {
    private final SocialUserRepo socialUserRepo;
    private final PostRepo postRepo;
    private final SocialGroupRepo socialGroupRepo;
    private final SocialProfileRepo socialProfileRepo;

    public DataIntialzier(SocialUserRepo socialUserRepo, PostRepo postRepo, SocialGroupRepo socialGroupRepo, SocialProfileRepo socialProfileRepo) {
        this.socialUserRepo = socialUserRepo;
        this.postRepo = postRepo;
        this.socialGroupRepo = socialGroupRepo;
        this.socialProfileRepo = socialProfileRepo;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return (args) -> {
            //create some  users
            SocialUser socialUser = new SocialUser();
            SocialUser socialUser2 = new SocialUser();
            SocialUser socialUser3 = new SocialUser();
            SocialUser socialUser4 = new SocialUser();
            //save users
            socialUserRepo.save(socialUser);
            socialUserRepo.save(socialUser2);
            socialUserRepo.save(socialUser3);
            // create some groups
            SocialGroup socialGroup = new SocialGroup();
            SocialGroup socialGroup2 = new SocialGroup();
            //Add Users into Groups Groups
            socialGroup.getSocialUsers().add(socialUser);
            socialGroup.getSocialUsers().add(socialUser2);

            socialGroup2.getSocialUsers().add(socialUser3);
            socialGroup2.getSocialUsers().add(socialUser4);
            //Save Groups
            socialGroupRepo.save(socialGroup);
            socialGroupRepo.save(socialGroup2);
            //Associate  users with groups
            socialUser.getGroups().add(socialGroup);
            socialUser2.getGroups().add(socialGroup2);
            socialUser3.getGroups().add(socialGroup);
            socialUser4.getGroups().add(socialGroup2);
            //create Posts
            Post post = new Post();
            Post post2 = new Post();
            Post post3 = new Post();
            Post post4 = new Post();
            // Asscoiate Posts to the Users
            post.setSocialUser(socialUser);
            post2.setSocialUser(socialUser2);
            post3.setSocialUser(socialUser3);
            post4.setSocialUser(socialUser4);
            // save Post
            postRepo.save(post);
            postRepo.save(post2);
            postRepo.save(post3);

            // create social profile
            SocialProfile socialProfile = new SocialProfile();
            SocialProfile socialProfile2 = new SocialProfile();
            //Associale Profile with USers
            socialProfile.setSocialUser(socialUser);
            socialProfile.setSocialUser(socialUser2);
            socialProfile2.setSocialUser(socialUser3);
            socialProfile2.setSocialUser(socialUser4);
            //save social profile
            socialProfileRepo.save(socialProfile);
        };
    }
}
