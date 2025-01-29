package com.social.media.controllers;

import com.social.media.model.SocialUser;
import com.social.media.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;
    @GetMapping("social/getAllUsers")
    public ResponseEntity<List<SocialUser>> getAllUsers() {
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("social/createUsers")
    public ResponseEntity<SocialUser> createUsers(@RequestBody SocialUser socialUser) {
       return new ResponseEntity<>(socialService.createUser(socialUser),HttpStatus.CREATED);
    }
    @DeleteMapping("social/deleteUsers/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
        socialService.deleteUser(id);
        return new ResponseEntity<>("Deleted SuccessFully",HttpStatus.CREATED);
    }
}
