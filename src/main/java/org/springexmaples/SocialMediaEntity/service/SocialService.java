package org.springexmaples.SocialMediaEntity.service;

import org.springexmaples.SocialMediaEntity.model.SocialUser;
import org.springexmaples.SocialMediaEntity.repo.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocialService {
    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getUsers() {
        return socialUserRepository.findAll();


    }

    public SocialUser createUser(SocialUser socialUser) {


            if (socialUser.getSocialProfile() != null) {
                socialUser.setSocialProfile(socialUser.getSocialProfile());
            }
            return socialUserRepository.save(socialUser);
        }
    }

