package org.springexmaples.SocialMediaEntity.controller;


import org.springexmaples.SocialMediaEntity.model.SocialUser;
import org.springexmaples.SocialMediaEntity.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
private SocialService socialService;


    @GetMapping("/users/")
    public ResponseEntity<List<SocialUser>> getUser(){
        return new ResponseEntity<>(socialService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/get/Users/")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser socialUser){
      SocialUser social =  socialService.createUser(socialUser);
        return new ResponseEntity<>(social,HttpStatus.CREATED);

    }
}
