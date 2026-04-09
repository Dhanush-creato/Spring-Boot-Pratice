package org.springexmaples.SocialMediaEntity;

import org.springexmaples.SocialMediaEntity.model.Post;
import org.springexmaples.SocialMediaEntity.model.SocialGroup;
import org.springexmaples.SocialMediaEntity.model.SocialProfile;
import org.springexmaples.SocialMediaEntity.model.SocialUser;
import org.springexmaples.SocialMediaEntity.repo.PostRepository;
import org.springexmaples.SocialMediaEntity.repo.SocialGroupRepository;
import org.springexmaples.SocialMediaEntity.repo.SocialProfileRepository;
import org.springexmaples.SocialMediaEntity.repo.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataIntegiry {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SocialGroupRepository socialGroupRepository;
    @Autowired
    private SocialProfileRepository socialProfileRepository;
    @Autowired
    private SocialUserRepository socialUserRepository;

    @Bean
    public CommandLineRunner intilizeData(){
        return  args -> {

           //--->
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();


            user1.setName("Dhanush");
            user2.setName("Abhi");
            user3.setName("Yash");
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            //------>
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            user1.addSocialGroup(group1);
            user2.addSocialGroup(group1);
            user3.addSocialGroup(group2);
            user2.addSocialGroup(group2);

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            //-->
            Post post1 = new Post();
            Post post2= new Post();
            Post post3= new Post();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);


            //-->
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            user1.setSocialProfile(profile1);
//            profile1.setSocialUser(user1);
//            profile2.setSocialUser(user2);
//            profile3.setSocialUser(user3);
            user2.setSocialProfile(profile2);
            user3.setSocialProfile(profile3);

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            System.out.println("Fetch query");
            socialUserRepository.findById(1L);





        };
    }
}
