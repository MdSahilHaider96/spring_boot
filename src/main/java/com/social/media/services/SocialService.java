package com.social.media.services;

import com.social.media.model.SocialUser;
import com.social.media.repository.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
private SocialUserRepo socialUserRepo;

    public List<SocialUser> getAllUsers() {
        return socialUserRepo.findAll();
    }
    public SocialUser createUser( SocialUser socialUser) {
        return socialUserRepo.save(socialUser);
    }
    public SocialUser deleteUser( Long id) {
        SocialUser optionalId = socialUserRepo.findById(id).orElseThrow(() -> new RuntimeException("Social user not found"));
         socialUserRepo.delete(optionalId);
         return optionalId;
    }
}
